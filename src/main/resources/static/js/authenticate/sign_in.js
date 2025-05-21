
// show password
const showPasswordCheckbox = document.getElementById("showPassword");
const passwordInput = document.getElementById("password");

showPasswordCheckbox.addEventListener("change", function () {
    if (this.checked) {
        passwordInput.type = "text";
    } else {
        passwordInput.type = "password";
    }
});


document.getElementById('showPassword').addEventListener('change', function() {
    const passwordInput = document.getElementById('password');
    if (this.checked) {
        passwordInput.type = 'text';
    } else {
        passwordInput.type = 'password';
    }
});


// báo lỗi ở các thanh input khi đăng nhập
document.getElementById('signInForm').addEventListener('submit', function(event) {
    let valid = true;

    const emailInput = document.getElementById('email');
    const passwordInput = document.getElementById('password');
    const emailError = document.getElementById('emailError');
    const passwordError = document.getElementById('passwordError');

    // Reset error states
    emailInput.classList.remove('border-red-500');
    passwordInput.classList.remove('border-red-500');
    emailError.classList.add('hidden');
    passwordError.classList.add('hidden');

    if (!emailInput.value.trim()) {
        emailInput.classList.add('border-red-500');
        emailError.classList.remove('hidden');
        valid = false;
    }

    if (!passwordInput.value.trim()) {
        passwordInput.classList.add('border-red-500');
        passwordError.classList.remove('hidden');
        valid = false;
    }

    if (!valid) {
        event.preventDefault();
    }
});

// show modal
window.addEventListener('DOMContentLoaded', () => {
    const successModal = document.getElementById('successModal');
    const modalContent = document.getElementById('modalContent');
    if (successModal) {
        // Show modal with fade and scale animation
        successModal.classList.remove('opacity-0', 'pointer-events-none');
        modalContent.classList.remove('opacity-0', 'scale-90');

        const redirectUrl = successModal.getAttribute('data-redirect-url');
        if (redirectUrl) {
            setTimeout(() => {
                // Animate modal out
                modalContent.classList.add('opacity-0', 'scale-90');
                successModal.classList.add('opacity-0');
                // After animation ends, hide modal and redirect
                setTimeout(() => {
                    successModal.style.display = 'none';
                    window.location.href = redirectUrl;
                }, 500);
            }, 1500);
        }
    }
});