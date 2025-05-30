const imageUpload = document.getElementById('imageUpload');
const previewContainer = document.getElementById('previewContainer');
const previewImage = document.getElementById('previewImage');
const backgroundColorInput = document.getElementById('backgroundColor');
const colorPreview = document.getElementById('colorPreview');

imageUpload.addEventListener('change', () => {
    const file = imageUpload.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = e => {
            previewImage.src = e.target.result;
            previewContainer.classList.remove('hidden');
        };
        reader.readAsDataURL(file);
    } else {
        previewImage.src = '';
        previewContainer.classList.add('hidden');
    }
});

function isValidGradient(str) {
    return /linear-gradient|radial-gradient/.test(str);
}

backgroundColorInput.addEventListener('input', () => {
    const val = backgroundColorInput.value.trim();
    if (!val) {
        colorPreview.style.background = 'transparent';
        colorPreview.textContent = '';
        return;
    }
    try {
        if (isValidGradient(val)) {
            colorPreview.style.background = val;
            colorPreview.textContent = '';
        } else if (/^#([0-9A-F]{3}){1,2}$/i.test(val)) {
            colorPreview.style.background = val;
            colorPreview.textContent = '';
        } else {
            colorPreview.style.background = 'transparent';
            colorPreview.textContent = 'Màu không hợp lệ';
            colorPreview.style.color = '#b91c1c';
            colorPreview.style.fontWeight = '600';
            colorPreview.style.fontSize = '0.875rem';
            colorPreview.style.display = 'flex';
            colorPreview.style.alignItems = 'center';
            colorPreview.style.justifyContent = 'center';
        }
    } catch {
        colorPreview.style.background = 'transparent';
        colorPreview.textContent = 'Màu không hợp lệ';
        colorPreview.style.color = '#b91c1c';
        colorPreview.style.fontWeight = '600';
        colorPreview.style.fontSize = '0.875rem';
        colorPreview.style.display = 'flex';
        colorPreview.style.alignItems = 'center';
        colorPreview.style.justifyContent = 'center';
    }
});