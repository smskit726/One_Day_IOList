document.addEventListener("DOMContentLoaded", function () {
  document.querySelector("#btn-calc").addEventListener("click", function () {
    let total = document.querySelector("#io_price").innerHTML;
    console.log(total);
  });

  document.querySelector("#btn-save").addEventListener("click", function () {
    document.location.href("/iolist/write");
  });
});
