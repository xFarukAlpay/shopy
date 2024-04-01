document.addEventListener('DOMContentLoaded', function() {
    const addToCartButtons = document.querySelectorAll('.addToCart');
    const cartCount = document.querySelector('#cartCount');
    let itemCount = 0;

    cartCount.style.display = 'none'; //ilk başta sayacı gizliyoruz sepete hiç ürün eklemediğimiz için

    addToCartButtons.forEach(button => {
        button.addEventListener('click', function() {
            itemCount++;
            cartCount.textContent = itemCount;
            cartCount.style.display = 'inline'; //sayacı güncelledikten sonra görünür hale getiriyoruz

            const product = {
                name: button.parentElement.querySelector('.card-title').textContent.trim(),
                price: button.parentElement.querySelector('.text-muted').textContent.trim()
            };


            let cartItems = localStorage.getItem('cartItems');
            cartItems = cartItems ? JSON.parse(cartItems) : [];
            cartItems.push(product); //ürünü sepete ekler
            localStorage.setItem('cartItems', JSON.stringify(cartItems));
        });
    });
});
