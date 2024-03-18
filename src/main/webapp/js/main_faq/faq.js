document.addEventListener("DOMContentLoaded", function() {
    var faqQuestions = document.querySelectorAll(".faq-question");

    faqQuestions.forEach(function(question) {
        question.addEventListener("click", function() {
            var answer = this.nextElementSibling;
            var otherAnswers = document.querySelectorAll(".faq-answer");

            otherAnswers.forEach(function(otherAnswer) {
                if (otherAnswer != answer) {
                    otherAnswer.style.display = "none";
                }
            });

            if (answer.style.display === "block") {
                answer.style.display = "none";
            } else {
                answer.style.display = "block";
            }
        });
    });
});
