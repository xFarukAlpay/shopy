document.addEventListener('DOMContentLoaded', function() {
    const cartTableBody = document.querySelector('#shoppingCart tbody');
    const cartItemCount = document.getElementById('cartItemCount');
    const cartItemCountLabel = document.getElementById('cartItemCountLabel');
    let cartItems = localStorage.getItem('cartItems');
    cartItems = cartItems ? JSON.parse(cartItems) : [];

    // sepettekileri görüntülemek için
    function displayCartItems() {
        cartTableBody.innerHTML = '';
        if (cartItems.length === 0) {
            cartItemCount.textContent = '0';
            cartItemCountLabel.textContent = '';
            cartItemCount.style.display = 'none';
            cartItemCountLabel.innerHTML='0';
        } else {
            const existingNoItemMessage = document.getElementById('noItemMessage');
            if (existingNoItemMessage) {
                existingNoItemMessage.remove();
            }
            cartItems.forEach((item, index) => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td><input type="number" class="form-control form-control-lg text-center quantity-input" value="${item.quantity || 1}" data-index="${index}" min="1"></td>
                    <td class="actions">
                        <div class="text-right">
                            <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor" class="bi bi-trash delete-item" data-index="${index}" viewBox="0 0 16 16">
                                <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/><path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                            </svg>
                        </div>
                    </td>
                `;
                cartTableBody.appendChild(row);
            });
            updateCartItemCount();
        }
    }
    

    // sepetteki ürün sayısını güncellemek için
    function updateCartItemCount() {
        let totalCount = 0;
        cartItems.forEach(item => {
            totalCount += Math.max(item.quantity || 0, 1); // ürün sayısının en az 1 olduğunu kontrol eder
        });
        cartItemCount.textContent = totalCount;
        cartItemCountLabel.textContent = totalCount;
        
        /* sepette ürün yokken sayacı göstermez */
        cartItemCount.style.display = totalCount > 0 ? 'inline-block' : 'none';
        cartItemCountLabel.style.display = totalCount > 0 ? 'inline-block' : 'none';
    }

    displayCartItems();

    // sepetten ürünleri siler
    function deleteItemFromCart(index) {
        cartItems.splice(index, 1);
        localStorage.setItem('cartItems', JSON.stringify(cartItems));
        displayCartItems(); 
    }

    cartTableBody.addEventListener('click', function(event) {
        if (event.target.classList.contains('delete-item')) {
            const index = event.target.dataset.index;
            deleteItemFromCart(index);
        }
    });

    // miktar girişi değişikliği için
    cartTableBody.addEventListener('change', function(event) {
        if (event.target.classList.contains('quantity-input')) {
            const index = event.target.dataset.index;
            let newQuantity = parseInt(event.target.value); 
            if (newQuantity <= 0 || isNaN(newQuantity)) { //miktarın NaN ya da negatif olmadığını kontrol eder
                newQuantity = 1;
            }
            cartItems[index].quantity = newQuantity;
            localStorage.setItem('cartItems', JSON.stringify(cartItems));
            updateCartItemCount(); // Miktar değişikliğinden sona sepet ürün sayısını günceller 
        }
    });
});
