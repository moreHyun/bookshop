function scrollToTop() {
  window.scrollTo({ top: 0, behavior: 'smooth' });
}



document.addEventListener("DOMContentLoaded", function() {
  var currentPath = window.location.pathname;
  var menuLinks = document.querySelectorAll(".sub-menu a");

  menuLinks.forEach(function(link) {
    if (link.getAttribute("href") === currentPath) {
      link.classList.add("active"); // 'active' 클래스를 추가하는 부분
    }

  });
});


function validateInput() {
    const userPhone = document.getElementById('invoiceNumber');
    const userPhoneValue = userPhone.value.trim();
    const regex = /^\d{8}$/;
    const errorMessage = document.getElementById('error-message');

    if (!regex.test(userPhoneValue)) {
        errorMessage.textContent = '송장번호는 8자리 숫자만 입력해주세요.';
    } else {
        errorMessage.textContent = '';
    }
}

