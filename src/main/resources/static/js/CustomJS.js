/*$(function () {
//alert("welcome")
    // $("div").html("<p>hi</p>")

    // var text = $("p").text();
    // console.log(text)

    // $("p.red-box").hide(1000);
    // $("p.red-box").show(1000);
    // $("p.red-box").toggle(1000);
    // $("p.red-box").fadeOut(1000);
    // $("p.red-box").fadeIn(1000);
    // $("p.red-box").fadeTo(1000,0.2);
    // $("p.red-box").fadeToggle();
    // $("p.red-box").slideUp(1000);
    // $("p.red-box").slideDown(1000);
    // $("p.red-box").slideToggle(1000);

    // $("p.red-box").removeClass("red-box")

    // var isTrue = true;
    // $("button").on("click",function(){
    //     $("p.red-box").toggle();
    //     if(isTrue){
    //         $(this).text("Show");
    //         isTrue=false
    //     }else{
    //         $(this).text("Hide");
    //         isTrue=true
    //     }
    // });

    // $("button").on("mouseleave",function(){
    //     $("p.red-box").toggle();
    // });

    // console.log($("button").val())

    // $("form").on("submit",function(){
    //     console.log($("#name").val())
    //     $("#name1").val($("#name").val());
    // })

    // $("button").css({
    //     "background-color":"green"
    // })

    // $("button").on("click",function(){
    //     $(this).addClass("red-box")
    // })

    // $("button").on("click",function(){
    //     $(this).attr("id","blue-box")
    // })

    //  $("button").on("click",function(){
    //     $(this).attr("class","green-box")
    // })


    // $("#list + div").css({
    //     "color":"green"
    // })

    // $("ul[id='second']").hide();

    // $("ul#second + div").css({
    //     "boader":"1px solid green"
    // });

    // $("div[class!='id2']").css({
    //     "boader": "1px solid green"
    // });

    // $("button").on("click", function () {
    //     $.ajax({
    //         url: "..js/demo_test.txt", success: function (result) {
    //             $("#div1").html(result);
    //         }
    //     });
    // });

    var url = 'https://dummyjson.com/products/1';

    // $("button").on("click", function () {
    //     $.ajax({
    //         url: url,
    //         dataType: "json",
    //         type: "GET",
    //         success: function (result, status, xhr) {
    //             console.log(result)
    //             $("#div1").html(result);
    //         },
    //         error: function (xhr, status, error) {
    //             console.log(xhr.responseJSON)
    //         }
    //     });
    // });

    $("button").click(function(){
        $.get(url, 
            "json",
            function(data, status,xhr){
            console.log(data)
        //   alert("Data: " + data + "\nStatus: " + status);
        });  
      });

	$("button").click(function(){
		//alert("Successfully created")
      var id = $("#h1tag").data('idtest') ;  
        id?alert("Successfully created"):alert("Successfully Updated");
      });
      
      
  $("#basic-form").validate();

});*/

// Document is ready

$(document).ready(function () {

	// validate name
	$("#namecheck").hide();
	let nameError = true;
	$("#names").keyup(function () {
		validateName();
	});

	function validateName() {
		let nameValue = $("#names").val();
		if (nameValue.length == "") {
			$("#namecheck").show();
			nameError = false;
			return false;
		} else if (nameValue.length < 3 || nameValue.length > 10) {
			$("#namecheck").show();
			$("#namecheck").html("**Length of name must be between 3 and 10");
			nameError = false;
			return false;
		} else {
			nameError = true;
			$("#namecheck").hide();
		}
	}
	
	// validate grade
	$("#gradecheck").hide();
	let gradeError = true;
	$("#grade").keyup(function () {
		validateGrade();
	});

	function validateGrade() {
		let gradeValue = $("#grade").val();
		if (gradeValue.length == "") {
			$("#gradecheck").show();
			gradeError = false;
			return false;
		} else if (gradeValue.length < 1) {
			$("#gradecheck").show();
			$("#gradecheck").html("**Length of name must be one letter");
			gradeError = false;
			return false;
		} else {
			gradeError = true;
			$("#gradecheck").hide();
		}
	}
	
	// validate age
	$("#agecheck").hide();
	let ageError = true;
	$("#age").keyup(function () {
		validateAge();
	});

	function validateAge() {
		let ageValue = $("#age").val();
		if (ageValue == 0) {
			$("#agecheck").show();
			ageError = false;
			return false;
		} else if (ageValue < 18 || ageValue > 60) {
			$("#agecheck").show();
			$("#agecheck").html("**Age must be between 18 and 60");
			ageError = false;
			return false;
		} else {
			ageError = true;
			$("#agecheck").hide();
		}
	}
	
	// validate class
	$("#clzcheck").hide();
	let clzError = true;
	$("#clz").keyup(function () {
		validateClz();
	});

	function validateClz() {
		let clzValue = $("#clz").val();
		if (clzValue == 0) {
			$("#clzcheck").show();
			clzError = false;
			return false;
		} else if (clzValue < 3 || clzValue > 8) {
			$("#clzcheck").show();
			$("#clzcheck").html("**Length of class must be between 3 and 8");
			clzError = false;
			return false;
		} else {
			clzError = true;
			$("#clzcheck").hide();
		}
	}
	
	// validate tp
	$("#tpcheck").hide();
	let tpError = true;
	$("#tp").keyup(function () {
		validateTP();
	});

	function validateTP() {
		let tpValue = $("#tp").val();
		if (tpValue.length == "") {
			$("#tpcheck").show();
			tpError = false;
			return false;
		} else if (tpValue == 10) {
			$("#tpcheck").show();
			$("#tpcheck").html("**Tel.Phone number must be 10");
			tpError = false;
			return false;
		} else {
			tpError = true;
			$("#tpcheck").hide();
		}
	}
	
	// validate email
	$("#emailcheck").hide();
	let emailError = true;
	$("#email").keyup(function () {
		validateEmail();
	});

	function validateEmail() {
		let emailValue = $("#email").val();
		var regEx = /^[a-z0-9]+@[a-z]+\.[a-z]{2,3}$/;
        var validEmail = regEx.test(emailValue);
		if (emailValue.length == "") {
			$("#emailcheck").show();
			emailError = false;
			return false;
		} else if (!validEmail) {
			$("#emailcheck").show();
			$("#emailcheck").html("**Enter a valid email");
			emailError = false;
			return false;
		} else {
			emailError = true;
			$("#emailcheck").hide();
		}
	}
	
	// validate mother name
	$("#mnamecheck").hide();
	let mnameError = true;
	$("#motherName").keyup(function () {
		validateMotherName();
	});

	function validateMotherName() {
		let mnameValue = $("#motherName").val();
		if (mnameValue.length == "") {
			$("#mnamecheck").show();
			mnameError = false;
			return false;
		} else if (mnameValue.length < 3 || mnameValue.length > 10) {
			$("#mnamecheck").show();
			$("#mnamecheck").html("**Length of mother name must be between 3 and 10");
			mnameError = false;
			return false;
		} else {
			mnameError = true;
			$("#mnamecheck").hide();
		}
	}
	
	// validate father name
	$("#fnamecheck").hide();
	let fnameError = true;
	$("#fatherName").keyup(function () {
		validateFatherName();
	});

	function validateFatherName() {
		let fnameValue = $("#fatherName").val();
		if (fnameValue.length == "") {
			$("#fnamecheck").show();
			fnameError = false;
			return false;
		} else if (fnameValue.length < 3 || fnameValue.length > 10) {
			$("#fnamecheck").show();
			$("#fnamecheck").html("**Length of father name must be between 3 and 10");
			fnameError = false;
			return false;
		} else {
			fnameError = true;
			$("#fnamecheck").hide();
		}
	}
	
	// validate ptp
	$("#ptpcheck").hide();
	let ptpError = true;
	$("#ptp").keyup(function () {
		validatePTP();
	});

	function validatePTP() {
		let ptpValue = $("#ptp").val();
		if (ptpValue.length == "") {
			$("#ptpcheck").show();
			ptpError = false;
			return false;
		} else if (ptpValue == 10) {
			$("#ptpcheck").show();
			$("#ptpcheck").html("**Tel.Phone number must be 10");
			ptpError = false;
			return false;
		} else {
			ptpError = true;
			$("#ptpcheck").hide();
		}
	}

	// Submit button
	$("#submitbtn").click(function () {
		validateName();
		validateGrade();
		validateAge();
		validateClz();
		validateTP();
		validateEmail();
		validateMotherName();
		validateFatherName();
		validatePTP();
		if (
			nameError == true &&
			gradeError == true &&
			ageError == true &&
			clzError == true &&
			tpError == true &&
			emailError == true &&
			mnameError == true &&
			fnameError == true &&
			ptpError == true
		) {
			return true;
		} else {
			return false;
		}
	});
	
	
	$('#teacher-form').submit(function(e) {
    var name = $('#name').val();
    var age = $('#age').val();
    var email = $('#email').val();
    var tp = $('#tp').val();
	//var isError = ture;
    $(".error").remove();
    if (name.length < 1) {
      $('#name').after('<span class="error">This field is required</span>');
      isError = false;
    }else if(name.length < 3){
    	isError =  false;
    	$('#name').after('<span class="error">Name must be at least 3 characters long</span>');
    }
    if (age.length < 1) {
      $('#age').after('<span class="error">This field is required</span>');
      isError =  false;
    }
    if (email.length < 1) {
      $('#email').after('<span class="error">This field is required</span>');
      isError =  false;
    } else {
      var regEx = /^[a-z0-9]+@[a-z]+\.[a-z]{2,3}$/;
      var validEmail = regEx.test(email);
      if (!validEmail) {
        $('#email').after('<span class="error">Enter a valid email</span>');
        isError  = false;
      }
    }
    if (tp.length  < 10) {
      $('#tp').after('<span class="error">Tel.Phone must be at least 10 digits long</span>');
      isError = false;
    }
    return isError;
  });
  
  function resetForm(){
  	$("#namecheck").hide();
  	$("#gradecheck").hide();
  	$("#agecheck").hide();
  	$("#clzcheck").hide();
  	$("#emailcheck").hide();
  	$("#tpcheck").hide();
  	$("#mnamecheck").hide();
  	$("#fnamecheck").hide();
  	$("#ptpcheck").hide();
  }
  
  $("#resetbtn").click(function(){
   resetForm();
    $("#resetbtn")[0].reset();
   
});

});


