const sectionButtonView = document.getElementById("section-button-view");

const lessonsBtn = document.getElementById("open-lessons");
const coursesBtn = document.getElementById("open-courses");
const studentsBtn = document.getElementById("open-students");
const instructorsBtn = document.getElementById("open-instructors");

const lessonsView = document.getElementById("lessons-management-view");
const coursesView = document.getElementById("courses-management-view");
const studentsView = document.getElementById("students-management-view");
const instructorsView = document.getElementById("instructors-management-view");

const backButtons = document.querySelectorAll("[data-back-button]");

function showSection(view) {
    sectionButtonView.classList.add("hidden");
    lessonsView.classList.add("hidden");
    coursesView.classList.add("hidden");
    studentsView.classList.add("hidden");
    instructorsView.classList.add("hidden");
    view.classList.remove("hidden");
}

lessonsBtn.addEventListener("click", () => {
    showSection(lessonsView);
});

coursesBtn.addEventListener("click", () => {
    showSection(coursesView);
});

studentsBtn.addEventListener("click", () => {
    showSection(studentsView);
});

instructorsBtn.addEventListener("click", () => {
    showSection(instructorsView);
});

backButtons.forEach((btn) => {
    btn.addEventListener("click", () => {
        lessonsView.classList.add("hidden");
        coursesView.classList.add("hidden");
        studentsView.classList.add("hidden");
        instructorsView.classList.add("hidden");
        sectionButtonView.classList.remove("hidden");
    });
});