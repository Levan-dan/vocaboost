// sử lý khi nộp bài khảo sát
function submitAnswers(event) {
    // event.preventDefault();

    let totalQuestions = 0;
    let correctAnswers = 0;

    const questions = document.querySelectorAll('.question-block');
    questions.forEach((block) => {
        totalQuestions++;

        const correct = block.dataset.correct;
        const name = block.dataset.name;
        const selected = block.querySelector(`input[name="${name}"]:checked`);
        const result = block.querySelector('.correct-answer');

        if (selected) {
            if (selected.value !== correct) {
                result.classList.remove('hidden');
                selected.parentElement.classList.add('bg-red-200');
            } else {
                selected.parentElement.classList.add('bg-green-200');
                correctAnswers++;
            }
        } else {
            result.classList.remove('hidden');
        }
    });

    // hiển thị điểm
    const scoreBox = document.getElementById('score-result');
    const percentage = (correctAnswers / totalQuestions) * 100;

    let icon = percentage >= 70
        ? '<i class="ph ph-smiley text-4xl text-green-300 mb-2"></i>'
        : '<i class="ph ph-warning text-4xl text-red-300 mb-2"></i>';

    let message = percentage >= 70
        ? `🎉 You got ${correctAnswers}/${totalQuestions} questions correct. Great job!`
        : `😢 You only got ${correctAnswers}/${totalQuestions} correct. Keep trying!`;

    scoreBox.innerHTML = icon + '<br>' + message;
    scoreBox.classList.remove('hidden');
    scoreBox.classList.add(percentage >= 70 ? 'bg-green-600' : 'bg-red-600');
    scoreBox.classList.add('text-white');
}

