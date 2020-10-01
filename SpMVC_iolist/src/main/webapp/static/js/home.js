document.addEventListener("DOMContentLoaded", function () {
  let i_list = document.querySelectorAll(".i_price");
  let o_list = document.querySelectorAll(".o_price");
  let i_total = 0;
  let o_total = 0;

  i_list.forEach(function (obj) {
    i_total += Number(obj.innerHTML);
  });

  o_list.forEach(function (obj) {
    o_total += Number(obj.innerHTML);
  });

  //   console.log(i_total);
  //   console.log(o_total);

  document.querySelector("#i_total").innerHTML = i_total;
  document.querySelector("#o_total").innerHTML = o_total;

  let io_list = document.querySelectorAll(".pro_item");
  io_list.forEach(function (obj) {
    obj.addEventListener("click", function () {
      let id = obj.getAttribute("data-id");
      document.location.href = `${rootPath}/detail/${id}`;
    });
  });
});
