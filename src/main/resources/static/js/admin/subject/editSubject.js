// Image preview
const imageUpload = document.getElementById("imageUpload");
const previewContainer = document.getElementById("previewContainer");
const previewImage = document.getElementById("previewImage");

imageUpload.addEventListener("change", (e) => {
    const file = e.target.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function (event) {
            previewImage.src = event.target.result;
            previewContainer.classList.remove("hidden");
        };
        reader.readAsDataURL(file);
    } else {
        previewImage.src = "";
        previewContainer.classList.add("hidden");
    }
});

// Background color input and preview sync

const backgroundColorInput = document.getElementById("backgroundColor");
const colorPreview = document.getElementById("colorPreview");

function updateColorPreview(value) {
    if (!value) {
        colorPreview.style.background = "transparent";
        return;
    }
    try {
        colorPreview.style.background = value;
    } catch (e) {
        colorPreview.style.background = "transparent";
    }
}

backgroundColorInput.addEventListener("input", (e) => {
    const val = e.target.value.trim();
    updateColorPreview(val);
});

document.addEventListener("DOMContentLoaded", () => {
    updateColorPreview(backgroundColorInput.value.trim());
});

