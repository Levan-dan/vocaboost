// tìm kiếm
document.getElementById('searchInput').addEventListener('keyup', function () {
    const keyword = this.value;

    fetch(`/user/searchSubjects?keySubject=${encodeURIComponent(keyword)}`)
        .then(response => response.text())
        .then(html => {
            // Chèn kết quả vào phần hiển thị bài học (ví dụ: #subjectList)
            document.getElementById('subjectList').innerHTML = html;
        })
        .catch(error => {
            console.error('Error fetching search results:', error);
        });
});