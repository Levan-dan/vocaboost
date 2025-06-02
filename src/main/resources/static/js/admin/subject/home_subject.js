// Hiển thị modal xóa bài học
function openDeleteModal(button) {
    const modal = document.getElementById('deleteModal');
    const lessonNameSpan = document.getElementById('lessonName');
    const deleteForm = document.getElementById('deleteForm');

    const lessonName = button.getAttribute('data-lesson-name');
    const deleteUrl = button.getAttribute('data-delete-url');

    lessonNameSpan.textContent = lessonName;
    deleteForm.action = deleteUrl;

    modal.classList.remove('hidden');

    // Tự động focus nút "Delete" trong modal (hữu ích cho accessibility)
    modal.querySelector('button[type="submit"]').focus();
}

// Ẩn modal
function closeDeleteModal() {
    const modal = document.getElementById('deleteModal');
    modal.classList.add('hidden');
}

// Đóng modal khi nhấn Escape
document.addEventListener('keydown', (e) => {
    const modal = document.getElementById('deleteModal');
    if (!modal.classList.contains('hidden') && e.key === 'Escape') {
        closeDeleteModal();
    }
});

// Đóng modal nếu click ra ngoài phần nội dung
document.getElementById('deleteModal').addEventListener('click', (e) => {
    if (e.target.id === 'deleteModal') {
        closeDeleteModal();
    }
});




// tìm kiếm
document.getElementById('searchInput').addEventListener('keyup', function () {
    const keyword = this.value;

    fetch(`/admin/searchSubjects?keySubject=${encodeURIComponent(keyword)}`)
        .then(response => response.text())
        .then(html => {
            // Chèn kết quả vào phần hiển thị bài học (ví dụ: #subjectList)
            document.getElementById('subjectList').innerHTML = html;
        })
        .catch(error => {
            console.error('Error fetching search results:', error);
        });
});