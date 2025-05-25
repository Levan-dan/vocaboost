
document.addEventListener('DOMContentLoaded', () => {
    const startBtn = document.getElementById('start-learning-btn');
    const successModal = document.getElementById('successModal');
    const modalContent = document.getElementById('modalContent');

    if (startBtn && successModal && modalContent) {
        startBtn.addEventListener('click', () => {
            // Hiển thị modal
            successModal.classList.remove('opacity-0', 'pointer-events-none');
            modalContent.classList.remove('opacity-0', 'scale-90');

            const redirectUrl = successModal.getAttribute('data-redirect-url') || '/homeWeb/showLogInForm';

            // Chuyển hướng sau 1.5s
            setTimeout(() => {
                modalContent.classList.add('opacity-0', 'scale-90');
                successModal.classList.add('opacity-0');
                setTimeout(() => {
                    successModal.style.display = 'none';
                    window.location.href = redirectUrl;
                }, 500);
            }, 1500);
        });
    }
});


