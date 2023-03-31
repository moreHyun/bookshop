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
  let items = document.getElementsByClassName("cart-item");
  let code = 0;
  let cartCode = [];
  for(let i = 0; i < items.length; i++)
  {
    if(items[i].getElementsByClassName("product-checkbox")[0].checked)
    {
      code = items[i].getElementsByClassName("item-code")[0].textContent;
      cartCode.push(code)
    }
  }
  fetch("/cart/delete", {
    method: 'POST',
    headers:
        {
          'Content-Type': 'application/json'
        },
    body: JSON.stringify(cartCode)
  })
      .then(response => {
        if (response.ok) {
          console.log('데이터가 성공적으로 전송되었습니다.');
        } else {
          console.error('데이터 전송이 실패하였습니다.');
        }
      })
      .catch(error => console.error('에러 발생:', error));
  for (let i = 0; i < checkboxes.length; i++)
  {
    if (checkboxes[i].checked)
    {
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
  let checkboxes = document.getElementsByClassName("product-checkbox");
  let items = document.getElementsByClassName("cart-item");
  let cartCode = [];
  for (let i = 0; i < items.length; i++) {
    if (items[i].getElementsByClassName("product-checkbox")[0].checked)
    {
      let code = items[i].getElementsByClassName("item-code")[0].textContent;
      cartCode.push(code);
    }
  }
  fetch("/cart/update", {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(cartCode)
  })
      .then(response => {
        if (response.ok)
        {
          for (let i = 0; i < checkboxes.length; i++)
          {
            if (checkboxes[i].checked)
            {
              checkboxes[i].parentNode.parentNode.remove();
            }
          }
        } else {
          console.error('데이터 전송이 실패하였습니다.');
        }
      })
      .catch(error => console.error('에러 발생:', error));
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