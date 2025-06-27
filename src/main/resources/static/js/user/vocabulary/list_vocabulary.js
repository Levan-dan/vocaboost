
function playAudio(word) {
    console.log("hhhhh")
    console.log(word)
    const url = `https://ssl.gstatic.com/dictionary/static/sounds/oxford/${word.toLowerCase()}--_gb_1.mp3`;
    console.log(word)
    const audio = new Audio(url);
    audio.onerror = () => {
        alert(`Không tìm thấy âm thanh cho từ "${word}"`);
    };
    audio.play();
}
