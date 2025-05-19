const menuBtn = document.getElementById('menu-btn');
const mobileMenu = document.getElementById('mobile-menu');

menuBtn.addEventListener('click', () => {
    if (mobileMenu.classList.contains('-translate-y-full')) {
        mobileMenu.classList.remove('-translate-y-full');
    } else {
        mobileMenu.classList.add('-translate-y-full');
    }
});

// Close mobile menu on link click
mobileMenu.querySelectorAll('a').forEach((link) => {
    link.addEventListener('click', () => {
        mobileMenu.classList.add('-translate-y-full');
    });
});