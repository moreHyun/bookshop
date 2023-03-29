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
