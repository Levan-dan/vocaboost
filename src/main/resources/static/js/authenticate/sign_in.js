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