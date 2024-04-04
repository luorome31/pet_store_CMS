//获取id为itemDetail的modal，在模型框展示时进行异步请求获取具体商品的信息，为获取完成则展示loading，获取完成后将数据展示在模型框中
$(document).ready(function () {
    $('#staticBackdrop').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);
        var itemId = button.data('itemid');
        var modal = $(this);
        modal.find('.modal-body').html('<div class="text-center"><i class="fa fa-spinner fa-spin fa-3x fa-fw"></i></div>');
        $.ajax({
            url: '/items/' + itemId,
            type: 'GET',
            success: function (data) {
                modal.find('.modal-title').text(data.name);
                modal.find('.modal-body').html(
                    '<div class="row">' +
                    '<div class="col-md-12">' +
                    '<img src="' + data.image + '" >' +
                    '<form>' +
                    '<label for="productName" class="form-label">Product Name</label>' +
                    '<input type="text" class="form-control" id="productName" value="' + data.product + '">' +
                    '<label for="category" class="form-label">Category</label>' +
                    '<input type="text" class="form-control" id="category" value="' + data.category + '">' +
                    '<label for="listPrice" class="form-label">List Price</label>' +
                    '<input type="number" class="form-control" id="listPrice" value="' + data.list_price.toFixed(2) + '">' +
                    '<label for="quantityAvailable" class="form-label">Quantity Available</label>' +
                    '<input type="number" class="form-control" id="quantityAvailable" value="' + data.quantity + '">' +
                    '<label for="description" class="form-label">Description</label>' +
                    '<textarea class="form-control" id="description">' + data.description + '</textarea>' +
                    '</form>' +
                    '</div>'
                );

            }
        });
    });
})