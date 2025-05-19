const avatarInput = document.getElementById('avatar');
const avatarPreview = document.getElementById('avatarPreview');
avatarInput.addEventListener('change', function () {
    const file = this.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function (e) {
            avatarPreview.setAttribute('src', e.target.result);
        }
        reader.readAsDataURL(file);
    } else {
        avatarPreview.setAttribute('src', 'https://placehold.co/160x160/png?text=Avatar+Preview');
    }
});

// hiển thị lỗi khi xác nhận mật khẩu
document.addEventListener("DOMContentLoaded", function () {
    const passwordInput = document.getElementById("password");
    const confirmInput = document.getElementById("confirmPassword");
    // Tạo hoặc lấy phần tử thông báo lỗi
    let mismatchDiv = document.getElementById("passwordMismatchMsg");
    if (!mismatchDiv) {
        const container = document.createElement("div");
        container.setAttribute("id", "passwordMismatchDiv");
        mismatchDiv = document.createElement("p");
        mismatchDiv.setAttribute("id", "passwordMismatchMsg");
        mismatchDiv.style.color = "red";
        container.appendChild(mismatchDiv);
        confirmInput.parentNode.appendChild(container);
    }
    function validatePasswordMatch() {
        const password = passwordInput.value;
        const confirm = confirmInput.value;
        if (confirm && password !== confirm) {
            mismatchDiv.innerText = "Passwords do not match.";
            mismatchDiv.style.display = "block";
            mismatchDiv.style.fontSize = "10px";
            mismatchDiv.style.color = "rgba(255, 0, 0, 0.84)";
        } else {
            mismatchDiv.innerText = "";
            mismatchDiv.style.display = "none";
        }
    }
    passwordInput.addEventListener("input", validatePasswordMatch);
    confirmInput.addEventListener("input", validatePasswordMatch);
});



// hiển thị lỗi cho các trường còn lại
document.addEventListener("DOMContentLoaded", function () {
    const usernameInput = document.getElementById("name");
    const emailInput = document.getElementById("email");
    const phoneInput = document.getElementById("phone");
    usernameInput.addEventListener("input", function () {
        const regex = /^(?!\s*$)(?!.*\s{2,})(?=.{3,50}$)[A-Za-z0-9 ]+$/;
        const error = document.getElementById("usernameError");
        if (regex.test(this.value)) {
            if (error) error.style.display = "none";
        } else {
            if (error) error.style.display = "block";
        }
    });
    emailInput.addEventListener("input", function () {
        const regex = /^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$/;
        const error = document.getElementById("emailError");
        if (regex.test(this.value)) {
            if (error) error.style.display = "none";
        } else {
            if (error) error.style.display = "block";
        }
    });
    phoneInput.addEventListener("input", function () {
        const regex = /^0\d{9}$/;
        const error = document.getElementById("phoneError");
        if (regex.test(this.value)) {
            if (error) error.style.display = "none";
        } else {
            if (error) error.style.display = "block";
        }
    });
});


