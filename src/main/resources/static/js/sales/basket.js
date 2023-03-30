// 체크박스를 전부 체크하는 함수
function selectAll() {
  let checkboxes = document.getElementsByClassName("product-checkbox");
  for (let i = 0; i < checkboxes.length; i++) {
    checkboxes[i].checked = true;
  }
}

// 체크박스를 전부 해제하는 함수
function deselectAll() {
  let checkboxes = document.getElementsByClassName("product-checkbox");
  for (let i = 0; i < checkboxes.length; i++) {
    checkboxes[i].checked = false;
  }
}

// 선택된 상품을 삭제하는 함수
function deleteSelected() {
  let checkboxes = document.getElementsByClassName("product-checkbox");
  for (let i = 0; i < checkboxes.length; i++) {
    if (checkboxes[i].checked) {
      checkboxes[i].parentNode.parentNode.remove();
    }
  }
}

// 상품 수량을 변경할 때마다 총 상품 가격을 업데이트하는 함수
function updateTotalPrice() {
  let items = document.getElementsByClassName("cart-item");
  let total = 0;
  let dprice = 0;
  let dicount = 0;
  let totalPrice = 0;
  for (let i = 0; i < items.length; i++)
  {
    let quantity = parseInt(items[i].getElementsByClassName("product-quantity")[0].value);
    let price = parseInt(items[i].getElementsByClassName("item-price")[0].textContent.replace(",", "").replace("원", ""));
    if(document.querySelector("item-discount") && dicount > 0)
    {
      dicount = parseInt(items[i].getElementsByClassName("item-discount")[0].textContent.replace(",","").replace("%" , ""))
      dprice = ((quantity * price) / dicount);
    }
    else
    {
      total = quantity * price;
    }
    if (items[i].getElementsByClassName("product-checkbox")[0].checked)
    {
      if(dprice > 1)
        totalPrice += total - dprice;
      else
        totalPrice += total;
    }
    items[i].getElementsByClassName("item-total")[0].textContent = total.toLocaleString() + "원";
  }
  if(totalPrice >= 13000)
    delivery = 0;
  else
    delivery = 3000;

  document.getElementById("delivery -price").textContent = delivery.toLocaleString();
  document.getElementById("total-price").textContent = totalPrice.toLocaleString();
  document.getElementById("discount-price").textContent = dprice.toLocaleString();
  document.getElementById("total-amount").textContent = (totalPrice + delivery).toLocaleString();
}


// 결제하기 버튼 클릭 시 호출되는 함수
function checkout() {
  let items = document.getElementsByClassName("cart-item");
  let selectedItems = [];
  for (let i = 0; i < items.length; i++) {
    if (items[i].getElementsByClassName("product-checkbox")[0].checked)
    {
      let name = items[i].getElementsByClassName("item-info")[0].getElementsByTagName("p")[0].textContent;
      let price = items[i].getElementsByClassName("item-price")[0].textContent;
      let quantity = items[i].getElementsByClassName("product-quantity")[0].value;
      selectedItems.push({ name: name, price: price, quantity: quantity });
    }
  }
  alert(JSON.stringify(selectedItems));
}

// 이벤트 리스너 등록
document.getElementById("select-all-checkbox").addEventListener("change", function() {
  if (this.checked) {
    selectAll();
  } else {
    deselectAll();
  }
  updateTotalPrice();
});
let itemClick = document.getElementsByClassName("item-checkbox");
for (let i = 0; i < itemClick.length; i++)
{
  itemClick[i].addEventListener("change",function ()
  {
    updateTotalPrice();
  })
}

document.getElementById("delete-selected-btn").addEventListener("click", function() {
  deleteSelected();
  updateTotalPrice();
});
let quantityInputs = document.getElementsByClassName("product-quantity");
for (let i = 0; i < quantityInputs.length; i++) {
  quantityInputs[i].addEventListener("change", function() {
    updateTotalPrice();
  });
}
document.getElementById("checkout-btn").addEventListener("click", function() {
  checkout();
});