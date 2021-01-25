
// delete product modal control
$('#delete-product').on('show.bs.modal', function (event) {
    // get row
    const row = $(event.relatedTarget)[0].parentElement.parentElement

    // get value from row
    const id = row.querySelector('.id-td').innerText.trim()
    const shoesName = row.querySelector('.name-td').innerText.trim()
    const size = row.querySelector('.size-td').innerText.trim()


    // log value test
    console.log(id, shoesName, size)




    // get form delete
    const modal = $(this)[0]
    const form = modal.querySelector('form')

    // // edit text

    modal.querySelector(".modal-body b").innerText = `${shoesName}, SIZE ${size}?`

    // asign id value to input
    form.querySelector("input").value = id

    // get button [Delete] of modal
    const button = modal.querySelector('#btn-delete-product');
    console.log(button);

    // add event when button click so will submit form delete
    button.addEventListener('click', (e) => {
        //form.submit()
        console.log("form submited");
    })

})

// edit product modal control
$('#edit-product').on('show.bs.modal', function (event) {

    // get row present
    const row = $(event.relatedTarget)[0].parentElement.parentElement

    // get modal
    const modal = $(this)[0]

    console.log(row, modal);

    // get value form row present to asign form edit account

    const id = row.querySelector('.id-td').innerText.trim()
    const name = row.querySelector('.name-td').innerText.trim()
    // const type = row.querySelector('.type-td').innerText.trim()
    // const size = row.querySelector('.size-td').innerText.trim()
    const price = row.querySelector('.price-td').innerText.trim()
    const stock = row.querySelector('.stock-td').innerText.trim()
    const active = row.querySelector('.active-td').innerText.trim()

    const description = row.querySelector('.description-input').value.trim()
    const category = row.querySelector('.category-input').value.trim()
    const color = row.querySelector('.color-input').value.trim()
    const image = row.querySelector('.image-input').value.trim()


    // console.log(id, name, type, size, price, stock, active, description, category);

// img maybe using
// const avatar = row.querySelector('td img').src

// const gender = row.querySelector('td input.gender').value
// const address = row.querySelector('td input.address').value

// console.log(id, fullname, email, phone , active, role, avatar, gender, address);
// const form = modal.querySelector("form")

    // should be call api but I using DOM
    // get element to asign value
    const idInput =  modal.querySelector('input[name="id"]')
    const nameInput = modal.querySelector('input[name="name"]')
    const categorySelect = modal.querySelector('select[name="category"]')
    const colorInput = modal.querySelector('input[name="color"]')
    const priceInput = modal.querySelector('input[name="price"]')
    // const typeofSelect = modal.querySelector('select[name="typeof"]')
    // const sizeSelect = modal.querySelector('select[name="size"]')
    const stockInput = modal.querySelector('input[name="quantity"]')
    const activeInput = modal.querySelector('input[name="active"]')
    const descriptionInput = modal.querySelector('textarea[name="description"]')

    // asign value

    idInput.value = id
    nameInput.value = name
    categorySelect.value = category
    colorInput.value = color
    priceInput.value = price
    // typeofSelect.value = (type == "Nam") ? 1 : 0
    // sizeSelect.value = size
    stockInput.value = stock
    activeInput.value = active
    descriptionInput.value = description




    // get button
    const button = modal.querySelector('#btn-edit-product');
    const form = modal.querySelector('form')


    // add event listener
    button.addEventListener('click', (e) => {

        idValue = idInput.value
        nameValue = nameInput.value
        colorValue = colorInput.value
        priceValue = priceInput.value
        stockValue = stockInput.value
        activeValue = activeInput.value
        descriptionValue = descriptionInput.value
        categoryValue = categorySelect.value
        // typeofValue = typeofSelect.value
        // sizeValue = sizeSelect.value



        // validate value
        if(idValue.length == 0 || nameValue.length == 0 || colorValue.length == 0 ||
            descriptionValue.length == 0 ||
            !(activeValue == 1 || activeValue == 0) || !(categoryValue > 0 && categoryValue < 7)) {
            return alert("Có lỗi! Vui lòng kiểm tra lại")
        }

        // if okie. submit form
        form.submit()

    })

})


// edit product modal control
$('#add-product').on('show.bs.modal', function (event) {

    // get row present
    const row = $(event.relatedTarget)[0].parentElement.parentElement

    // get modal
    const modal = $(this)[0]

    // should be call api but I using DOM
    // get element to asign value
    const nameInput = modal.querySelector('input[name="name"]')
    const categorySelect = modal.querySelector('select[name="category"]')
    const colorInput = modal.querySelector('input[name="color"]')
    const typeofSelect = modal.querySelector('select[name="typeof"]')

    const descriptionInput = modal.querySelector('textarea[name="description"]')

    const sizeSelect1 = modal.querySelector('select[name="size1"]')
    const stockInput1 = modal.querySelector('input[name="quantity1"]')
    const priceInput1 = modal.querySelector('input[name="price1"]')

    const sizeSelect2 = modal.querySelector('select[name="size2"]')
    const stockInput2 = modal.querySelector('input[name="quantity2"]')
    const priceInput2 = modal.querySelector('input[name="price2"]')

    const sizeSelect3 = modal.querySelector('select[name="size3"]')
    const stockInput3 = modal.querySelector('input[name="quantity3"]')
    const priceInput3 = modal.querySelector('input[name="price3"]')

    const sizeSelect4 = modal.querySelector('select[name="size4"]')
    const stockInput4 = modal.querySelector('input[name="quantity4"]')
    const priceInput4 = modal.querySelector('input[name="price4"]')

    const arrFile = modal.querySelectorAll('input[type="file"]')

    function addEvent(...arr) {
        for(let element of arr) {
            element.addEventListener('change', (e) => {
                if(e.target.value < 1) {
                    e.target.value = 1
                }
            })
        }
    }

    function checkEventFile(arr) {
        const elements = [...arr]
        for(let element of elements) {
            if(element.files.length !== 1) return false
        }
        return true;
    }

    addEvent(stockInput1, priceInput1, stockInput2,
        priceInput2, stockInput3, priceInput3, stockInput4, priceInput4)


    // get button
    const button = modal.querySelector('#btn-add-product');
    const form = modal.querySelector('form')


    // add event listener
    button.addEventListener('click', (e) => {

        nameValue = nameInput.value
        colorValue = colorInput.value
        descriptionValue = descriptionInput.value
        categoryValue = categorySelect.value
        typeofValue = typeofSelect.value

        if(!checkEventFile(arrFile)) return alert("Vui lòng chọn file cho chính xác!")

        // validate value
        if(nameValue.length == 0 || colorValue.length == 0 ||
            !(typeofValue == 1 || typeofValue == 0) || descriptionValue.length == 0 ||
            !(categoryValue > 0 && categoryValue < 7)) {
            return alert("Có lỗi! Vui lòng kiểm tra lại")
        }

        // if okie. submit form
        form.submit()

    })

})


