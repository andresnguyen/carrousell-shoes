
function pagination(destroy) {
    const container = $('#pagination-container')
    if(destroy === 'destroy') {
        container.pagination(destroy)
        return;
    }
    if(destroy === 'page') {
        loadPage(1)
        return;
    }

    container.pagination({
        dataSource: window.location.href + '&pagin=1&ajax=1&page=' + 1,
        locator: 'listShoes',
        totalNumberLocator: (response) => {
            return response.total
        },
        showPrevious: false,
        showNext: false,
        pageSize: 12,
        afterPageOnClick: (event, pageNumber) => {
            loadPage(pageNumber)
        }
    })



    function loadPage(page) {
        $.ajax({
            url: window.location.href + '&ajax=1&page=' + page
        })
            .then(renderPagination)
            .catch(err => {

            })
    }


    function renderPagination(response) {
        let containerShoes = document.querySelector('.spad .container .col-lg-9 > .row')

        let arrayRespone = response;

        if(typeof response === "string") {
            arrayRespone = JSON.parse(response);
        }

        let html = '';
        let img = ''
        for(let shoes of arrayRespone) {
            img = shoes.image.split(",")[0];
            html += `<div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="product__item sale">
                            <div class="product__item__pic set-bg" data-setbg="/resources/img${img}" style="background-image: url('/resources/img${img}')">
                            </div>
                            <div class="product__item__text">
                                <h6>${capitalize(getName(shoes.name).toLowerCase())}</h6>
                                <a href="/product-detail/${shoes.id}" class="add-cart">MUA NGAY</a>
                                <p>${capitalize(shoes.color.toLowerCase())}</p>
                                <h5>${formatNumber(shoes.price)} VND</h5>
                            </div>
                        </div>
                    </div>`
        }

        containerShoes.innerHTML = html;
    }
}

pagination()