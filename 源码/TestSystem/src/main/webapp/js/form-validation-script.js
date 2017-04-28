var Script = function () {
	
    $.validator.setDefaults({
        submitHandler: function(form) { 
        	form.submit();
        }
    });
    
  

    $().ready(function() {
        // validate the comment form when it is submitted
        $("#feedback_form").validate();

        // validate signup form on keyup and submit
        $("#register_form").validate({
            rules: {
                fullname: {
                    required: true,
                    minlength: 2
                },
                userno:{
                	required: true,
                	
                },
                address: {
                    required: true,
                    minlength: 10
                },
                username: {
                    required: true,
                    minlength: 5,
                    rangelength:[5,10]
                },
                password: {
                    required: true,
                    minlength: 5
                },
                confirm_password: {
                    required: true,
                    minlength: 5,
                    equalTo: "#password"
                },
                phone: {
                    required: true,
                    phone: true
                },
                topic: {
                    required: "#newsletter:checked",
                    minlength: 2
                },
                numcard:{
                	required:true,
                	minlength:18
                },
                email:{
                	required:true,
                },
                agree: "required"
            },
            messages: {                
                fullname: {
                    required: "Please enter a Full Name.请输入一个姓名。",
                    minlength: "Your Full Name must consist of at least 2 characters long.你的姓名的长度最小为2个字符。"
                },
              
                username: {
                    required: "Please enter a Username.请输入你的用户名。",
                    minlength: "Your username must consist of at least 5 characters long.你的用户名的长度最小为5个字符。",
                    rangelength:"Your username must be most 10 characters long.你的用户名的长度最大为10个字符。"
                },
                password: {
                    required: "Please provide a password.请输入一个密码。",
                    minlength: "Your password must be at least 5 characters long.你的密码最少为5个字符。"
                },
                confirm_password: {
                    required: "Please provide a password.请再次输入密码。",
                    minlength: "Your password must be at least 5 characters long.你的密码最少为5个字符。",
                    equalTo: "Please enter the same password as above.两次输入的密码不匹配。"
                },
                numcard:{
                	required:"Please provide a unmcard.请输入一个身份证号码。",
                	minlength:"Your unmcard must be at least 18 characters long.身份证号码长度不能小于18位"
                },
                userno:{
                	required: "Please provide a UserNo.请输入一个学号。",
                },
                phone: {
                	required:"Please enter a valid phone num.请输入一个手机号码。",
                },
                email:"Please enter a valid Email add.请输入一个正确的邮箱地址。",
                agree: "Please accept our terms & condition.",
                phone:"Please enter a valid phone num.请输入一个正确的手机号码。"
            }
        });

        // propose username by combining first- and lastname
        $("#username").focus(function() {
            var firstname = $("#firstname").val();
            var lastname = $("#lastname").val();
            if(firstname && lastname && !this.value) {
                this.value = firstname + "." + lastname;
            }
        });

        //code to hide topic selection, disable for demo
        var newsletter = $("#newsletter");
        // newsletter topics are optional, hide at first
        var inital = newsletter.is(":checked");
        var topics = $("#newsletter_topics")[inital ? "removeClass" : "addClass"]("gray");
        var topicInputs = topics.find("input").attr("disabled", !inital);
        // show when newsletter is checked
        newsletter.click(function() {
            topics[this.checked ? "removeClass" : "addClass"]("gray");
            topicInputs.attr("disabled", !this.checked);
        });
    });


}();