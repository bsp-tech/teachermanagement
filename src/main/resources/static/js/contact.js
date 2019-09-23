$(document).ready(function () {


    $('#addContactBtnId').click(function () {
        addContact();
    });


    function addContact() {

        var comboDepartment = $('#comboDepartmentId').val();
        var nameSurnameContact = $('#nameSurnameContactId').val();
        var emailContact = $('#emailContactId').val();
        var subjectContact = $('#subjectContactId').val();
        var messageContact = $('#messageContactId').val();

        var data = {

            comboDepartment: comboDepartment,
            nameSurnameContact: nameSurnameContact,
            emailContact: emailContact,
            subjectContact: subjectContact,
            messageContact: messageContact

        };

            $.ajax({

                url: '/addContact',
                type: 'POST',
                data: data,
                dataType: 'text',
                success: function (data) {
                    if (data === 'success') {
                        swal("Uğurlu!", "Mesajınız uğurla yollanıldı!", "success");
                        setTimeout(function () {
                            location.href = "/contact"
                        }, 2000);

                    } else {

                        swal("Error!", "Mesajınız uğurla yollanıldı!", "error");

                    }

                }


            });



    }

});


