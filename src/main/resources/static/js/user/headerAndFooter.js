// dropdown thong tin user
const userMenuButton = document.getElementById('userMenuButton');
const userDropdown = document.getElementById('userDropdown');

userMenuButton.addEventListener('click', () => {
    const isExpanded = userMenuButton.getAttribute('aria-expanded') === 'true';
    if (isExpanded) {
        userDropdown.classList.add('hidden');
        userMenuButton.setAttribute('aria-expanded', 'false');
    } else {
        userDropdown.classList.remove('hidden');
        userMenuButton.setAttribute('aria-expanded', 'true');
    }
});

// Close dropdown when clicking outside
document.addEventListener('click', (event) => {
    if (!userMenuButton.contains(event.target) && !userDropdown.contains(event.target)) {
        userDropdown.classList.add('hidden');
        userMenuButton.setAttribute('aria-expanded', 'false');
    }
});

// Close dropdown on Escape key
document.addEventListener('keydown', (event) => {
    if (event.key === 'Escape') {
        userDropdown.classList.add('hidden');
        userMenuButton.setAttribute('aria-expanded', 'false');
        userMenuButton.focus();
    }
});





// Show modal on logout
logoutLink.addEventListener('click', (e) => {
    e.preventDefault();
    userDropdown.classList.add('hidden');
    userMenuButton.setAttribute('aria-expanded', 'false');
    openLogoutModal();
});

function openLogoutModal() {
    logoutModal.classList.remove('hidden');
    logoutModalBackdrop.classList.remove('hidden');
    cancelLogoutBtn.focus();
    trapFocus(logoutModal);
}

function closeLogoutModal() {
    logoutModal.classList.add('hidden');
    logoutModalBackdrop.classList.add('hidden');
    releaseFocusTrap();
    userMenuButton.focus();
}

cancelLogoutBtn.addEventListener('click', () => {
    closeLogoutModal();
});

logoutModalBackdrop.addEventListener('click', () => {
    closeLogoutModal();
});

confirmLogoutBtn.addEventListener('click', () => {
    // Redirect to /user/logOut to trigger backend logout
    window.location.href = '/user/logOut';
});

// Focus trap implementation
let focusableElementsString = 'a[href], area[href], input:not([disabled]), select:not([disabled]), textarea:not([disabled]), button:not([disabled]), iframe, object, embed, [tabindex="0"], [contenteditable]';
let firstTabStop = null;
let lastTabStop = null;
let focusTrapActive = false;

function trapFocus(element) {
    if (focusTrapActive) return;
    focusTrapActive = true;
    let focusableElements = element.querySelectorAll(focusableElementsString);
    focusableElements = Array.prototype.slice.call(focusableElements);

    if (focusableElements.length === 0) return;

    firstTabStop = focusableElements[0];
    lastTabStop = focusableElements[focusableElements.length - 1];

    element.addEventListener('keydown', trapTabKey);
}

function releaseFocusTrap() {
    if (!focusTrapActive) return;
    focusTrapActive = false;
    logoutModal.removeEventListener('keydown', trapTabKey);
}

function trapTabKey(e) {
    if (e.key === 'Tab') {
        if (e.shiftKey) {
            if (document.activeElement === firstTabStop) {
                e.preventDefault();
                lastTabStop.focus();
            }
        } else {
            if (document.activeElement === lastTabStop) {
                e.preventDefault();
                firstTabStop.focus();
            }
        }
    }
    if (e.key === 'Escape') {
        closeLogoutModal();
    }
}


// show modal thong tin nguoi dung
const userInfoBtn = document.getElementById("userInfoBtn");
const userInfoModal = document.getElementById("userInfoModal");
const closeModalBtn = document.getElementById("closeModalBtn");
const avatarInput = document.getElementById("avatarInput");
const avatarImage = document.getElementById("avatarImage");
const saveBtn = document.getElementById("saveBtn");

// Store original avatar src to compare changes
let originalAvatarSrc = avatarImage.src;
let hasChanges = false;

// Show modal on link click
userInfoBtn.addEventListener("click", (e) => {
    e.preventDefault();
    userInfoModal.classList.remove("hidden");
    userInfoModal.setAttribute("aria-hidden", "false");
    closeModalBtn.focus();
    resetChanges();
});

// Close modal on close button click
closeModalBtn.addEventListener("click", () => {
    userInfoModal.classList.add("hidden");
    userInfoModal.setAttribute("aria-hidden", "true");
    userInfoBtn.focus();
    resetChanges();
});

// Close modal on clicking outside modal content
userInfoModal.addEventListener("click", (e) => {
    if (e.target === userInfoModal) {
        userInfoModal.classList.add("hidden");
        userInfoModal.setAttribute("aria-hidden", "true");
        userInfoBtn.focus();
        resetChanges();
    }
});

// Close modal on pressing Escape key
document.addEventListener("keydown", (e) => {
    if (e.key === "Escape" && !userInfoModal.classList.contains("hidden")) {
        userInfoModal.classList.add("hidden");
        userInfoModal.setAttribute("aria-hidden", "true");
        userInfoBtn.focus();
        resetChanges();
    }
});

// Update avatar image preview on file select
avatarInput.addEventListener("change", (e) => {
    const file = e.target.files[0];
    if (file && file.type.startsWith("image/")) {
        const reader = new FileReader();
        reader.onload = function (event) {
            avatarImage.src = event.target.result;
            checkChanges();
        };
        reader.readAsDataURL(file);
    } else {
        // If no valid image selected, revert to original
        avatarImage.src = originalAvatarSrc;
        checkChanges();
    }
});

// Check if changes exist to enable/disable save button
function checkChanges() {
    hasChanges = avatarImage.src !== originalAvatarSrc;
    if (hasChanges) {
        saveBtn.disabled = false;
        saveBtn.classList.remove("text-gray-400", "cursor-not-allowed", "select-none");
        saveBtn.classList.add("text-gray-800", "cursor-pointer");
    } else {
        saveBtn.disabled = true;
        saveBtn.classList.add("text-gray-400", "cursor-not-allowed", "select-none");
        saveBtn.classList.remove("text-gray-800", "cursor-pointer");
    }
}

// Reset changes state when modal closes or opens
function resetChanges() {
    avatarInput.value = "";
    avatarImage.src = originalAvatarSrc;
    hasChanges = false;
    saveBtn.disabled = true;
    saveBtn.classList.add("text-gray-400", "cursor-not-allowed", "select-none");
    saveBtn.classList.remove("text-gray-800", "cursor-pointer");
}

// Optional: handle save button click
saveBtn.addEventListener("click", () => {
    if (!hasChanges) return;
    // Here you can add your save logic, e.g., upload the new avatar to server
    alert("Ảnh đại diện đã được lưu!");
    // After saving, update originalAvatarSrc to current
    originalAvatarSrc = avatarImage.src;
    resetChanges();
    // Close modal after save
    userInfoModal.classList.add("hidden");
    userInfoModal.setAttribute("aria-hidden", "true");
    userInfoBtn.focus();
});
