
// delete account modal control
$('#delete-account').on('show.bs.modal', function (event) {
    // get id from row
    const row = $(event.relatedTarget)[0].parentElement.parentElement

    const id = row.querySelector('td.id').innerText.trim()
    const fullname = row.querySelector('td.fullname').innerText.trim()


    // get form delete
    const modal = $(this)[0]
    const form = modal.querySelector('form')

    // edit text

    modal.querySelector(".modal-body b").innerText = `${fullname}?`

    // asign id value to input
    form.querySelector("input").value = id

    // get button [Delete] of modal
    const button = modal.querySelector('#btn-delete-account');

    // add event when button click so will submit form delete
    button.addEventListener('click', (e) => {
        form.submit()
    })

})

// add account modal control
$('#add-account').on('show.bs.modal', function (event) {
    // get modal
    const modal = $(this)[0]

    // get button [Add] of modal
    const button = modal.querySelector('#btn-add-account');

    // get form
    const form = modal.querySelector("form")

    // add event when button clicked
    button.addEventListener('click', (e) => {

        // get value of form to validate
        const fullname = modal.querySelector('input[name="fullname"]').value
        const number = modal.querySelector('input[name="phone"]').value
        const email = modal.querySelector('input[name="email"]').value
        const password = modal.querySelector('input[name="password"]').value
        const repassword = modal.querySelector('input[name="repassword"]').value
        const gender = modal.querySelector('select[name="gender"]').value
        const address = modal.querySelector('input[name="address"]').value


        if(fullname.length == 0 || number.length == 0 || email.length == 0 || password.length < 6 ||
            (repassword !== password) || !(gender == '1' || gender == '0' ) || address.length == 0) {
            return alert("Có lỗi! Vui lòng kiểm tra lại.")
        }

        // if everything okie so will submit form
        form.submit()


    })


})

// edit account modal control
$('#edit-account').on('show.bs.modal', function (event) {

    // get row present
    const row = $(event.relatedTarget)[0].parentElement.parentElement

    // get modal
    const modal = $(this)[0]

    console.log(row);

    // get value form row present to asign form edit account

    const id = row.querySelector('td.id').innerText.trim()
    const fullname = row.querySelector('td.fullname').innerText.trim()
    const email = row.querySelector('td.email').innerText.trim()
    const phone = row.querySelector('td.phone').innerText.trim()
    const active = row.querySelector('td.active').innerText.trim()
    const role = row.querySelector('td.role').innerText.trim()
    // img maybe using
    const avatar = row.querySelector('td img').src

    const gender = row.querySelector('td input.gender').value
    const address = row.querySelector('td input.address').value

    console.log(id, fullname, email, phone , active, role, avatar, gender, address);
    const form = modal.querySelector("form")

    // should be call api but I using DOM
    // get element to asign value
    const fullnameInput = modal.querySelector('input[name="fullname"]')
    const numberInput = modal.querySelector('input[name="phone"]')
    const emailInput = modal.querySelector('input[name="email"]')
    const passwordInput = modal.querySelector('input[name="password"]')
    const repasswordInput = modal.querySelector('input[name="repassword"]')
    const genderSelect = modal.querySelector('select[name="gender"]')
    const addressInput = modal.querySelector('input[name="address"]')
    const activeInput = modal.querySelector('input[name="active"]')
    const roleInput = modal.querySelector('input[name="role"]')
    const idInput = modal.querySelector('input[name="id"]')
    const avatarInput = modal.querySelector('input[name="avatar"]')

    // asign value
    fullnameInput.value = fullname
    numberInput.value = phone
    emailInput.value = email
    genderSelect.value = gender
    addressInput.value = address
    activeInput.value = active
    roleInput.value = role
    idInput.value = id

    // get button
    const button = modal.querySelector('#btn-edit-account');

    // add event listener
    button.addEventListener('click', (e) => {
        const fullnameValue = fullnameInput.value
        const numberValue = numberInput.value
        const emailValue = emailInput.value
        const genderValue = genderSelect.value
        const addressValue = addressInput.value
        const activeValue = activeInput.value
        const roleValue = roleInput.value
        const idValue = idInput.value

        // check condition
        if(fullnameValue.length == 0 || numberValue.length < 5 || emailValue.length == 0 ||
            !(genderValue == 1 || genderValue == 0) || addressValue.length == 0 || !(activeValue == 1 || activeValue == 0) || !(roleValue == 1 || roleValue == 2)) {
            return alert("Có lỗi! Vui lòng kiểm tra lại")
        }

        // if okie. submit form
        form.submit()

    })

})
