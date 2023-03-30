document.addEventListener("DOMContentLoaded", function () {
  const userIdInput = document.getElementById("id");
  const saveIdCheckbox = document.getElementById("checkbox");

  // 저장된 아이디를 가져옵니다.
  const savedId = localStorage.getItem("savedId");
  if (savedId) {
    userIdInput.value = savedId;
    saveIdCheckbox.checked = true;
  }

  saveIdCheckbox.addEventListener("change", function () {
    if (saveIdCheckbox.checked) {
      localStorage.setItem("savedId", userIdInput.value);
    } else {
      localStorage.removeItem("savedId");
    }
  });

  userIdInput.addEventListener("input", function () {
    if (saveIdCheckbox.checked) {
      localStorage.setItem("savedId", userIdInput.value);
    }
  });
});