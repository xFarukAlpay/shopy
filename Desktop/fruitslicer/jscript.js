var playing = false;
var score;// Skor
var trialsleft; // Kalan canlar
var step;// Rastgele adımlar için
var action;// Zaman aralığı için
var fruits = ['1','2','3','4','5','6','7','8','9','10'];//// Meyveler için


$(function(){
    //click on start or reset button
    $('#front').show();
    $("#startReset").click(function () {
        if(playing == true){
            //eğer oyundaysa
            location.reload();//sayfayı yenile
        }else{
            //eger oyanamıyorsa
            $('#front').hide();
            $('#score').show();
            playing = true;
            //skoru sıfırla
            score = 0;
            $("#scoreValue").html(score);

            //kalan can

            $('#trialsleft').show();
            trialsleft=3;
            addhearts();

            //oyun bitiş gizleme
            $('#gameOver').hide();

            //oyunu sıfırlar
            $('#startReset').html('Reset Game')


            //oyunu baslat
            startAction();
        }
    });
        //meyve dilimleme yeri burası
        $("#fruit1").mouseover(function () {
            score++;// her meyve kesımınde skoru arttırır
            $("#scoreValue").html(score);

            //play sound
            $("#slicesound")[0].play();

            //meyveyı durdurur
            clearInterval(action);

            //meyveyi gizle
            $('#fruit1').hide("explode",500);//slice fruit

            //yeni meyve gınder
            setTimeout(startAction,500);
        });


  //fonksıyonlar burda

   //can ekleme
   function addhearts() {
    $('#trialsleft').empty();
    for(i = 0 ; i < trialsleft ; i++){
        $('#trialsleft').append('<img src="/images/wrong.png" , class="life">');
    }
}

  //Oyunu başlatma
  function startAction(){
      //Rastgele meyve oluştur
      $('#fruit1').show();

      //Rastgele meyve seç
      chooseRandom();
      //Rastgele pozisyon
      $('#fruit1').css({
          'left': Math.round(550 * Math.random()),
          'top': -50
      });
      // Rastgele adım oluştur
      step=1 + Math.round(5 * Math.random());//Adımları değiştir
      //Meyveleri 10ms aralıklarla indir
      action = setInterval(function(){
          //Meyveyi bir adım hareket ettir
          $('#fruit1').css('top', $('#fruit1').position().top + step);

          //Meyve çok alçaldı mı kontrol et
          if($('#fruit1').position().top > $('#fruitcontainer').height()-50){
              //  Kalan canları kontrol et
              if(trialsleft > 1){
                  //Bir meyve oluştur
                  $("#fruit1").show();
                  // Rastgele meyve seç
                  chooseRandom();
                  // Rastgele pozisyon
                  $('#fruit1').css({
                      'left': Math.round(550 * Math.random()),
                      'top': -50
                  });
                  // Rastgele adım oluştur
                  step= 1 + Math.round(5 * Math.random());//change steps

                  // Canı bir azalt
                  trialsleft--;
                  // Kalan can kutusunu bir artır
                  addhearts();

              }else{
                  //oyun bitti
                  playing=false;
                  $("#score").hide();
                  $('#startreset').html('Start Game');
                  $('#gameOver').show();
                  $('#gameOver').html('<p>Game Over!</p><p>Your score is '+ score + '</p>');
                  $('#trialsleft').hide();
                  stopAction();//durdur 
              }
          }
      },10);
  }

  //image klasoruındeki 1den 9a kadar adlandırılan meyveleri random secme fonksıyonu
  function chooseRandom(){
      $('#fruit1').attr('src','images/' + fruits[Math.round(9*Math.random())]+'.png');
  }
   // durdurma
   function stopAction(){
    clearInterval(action);
    $('#fruit1').hide();
}
});