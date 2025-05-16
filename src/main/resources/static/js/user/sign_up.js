const avatarInput = document.getElementById('avatar');
const avatarPreview = document.getElementById('avatarPreview');

avatarInput.addEventListener('change', function() {
    const file = this.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            avatarPreview.setAttribute('src', e.target.result);
        }
        reader.readAsDataURL(file);
    } else {
        avatarPreview.setAttribute('src', 'https://placehold.co/160x160/png?text=Avatar+Preview');
    }
});