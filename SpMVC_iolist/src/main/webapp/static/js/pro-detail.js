document.addEventListener("DOMContentLoaded", function () {
  document.querySelector("#pro-delete").addEventListener("click", function () {
    let id = document.querySelector("#pro-delete").getAttribute("data-id");
    if (confirm("정말 삭제하시겠어요?")) {
      document.location.replace(`${rootPath}/delete?id=${id}`);
    }
  });
});
