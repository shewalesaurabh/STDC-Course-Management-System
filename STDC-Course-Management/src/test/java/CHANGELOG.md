<?php
include("header.php");
include("sidebar.php");

$_SESSION[randomno] = rand();

	$sqltransaction = "SELECT * FROM loan_payment where payment_id='$_GET[receiptid]'";
	$qsqltransaction= mysqli_query($con,$sqltransaction);
	$rstransaction = mysqli_fetch_array($qsqltransaction);
	
	$sqlcustac ="SELECT * FROM customer WHERE customer_id='$rstransaction[customer_id]'";
 	$qsqlcustac = mysqli_query($con,$sqlcustac);
	$rscustac = mysqli_fetch_array($qsqlcustac);
	
	 $sqlbranch ="SELECT * FROM branch WHERE ifsc_code='$rscustac[ifsc_code]'";
 	$qsqlbranch = mysqli_query($con,$sqlbranch);
	$rsbranch = mysqli_fetch_array($qsqlbranch);

?>
     <div class="templatemo-content-wrapper">
        <div class="templatemo-content">
<div id="divprint">
         <center><h1>Loan Payment Receipt</h1></center>
          <div class="row">
            <div class="col-md-12">
              <form role="form" id="templatemo-preferences-form" name="frmtransaction" method="post" action="" onsubmit="return javascriptvalidation()">
                 <input  type="hidden" name="randomno" value="<?php echo $_SESSION[randomno]; ?>"  />

                  
<table  id="example1" class="table table-striped table-bordered" cellspacing="0" width="75%">
<thead> 
  <tr>
    <th scope="col">&nbsp;Name</th>
    <th scope="col">&nbsp;<?php echo $rscustac[first_name] . " ". $rscustac[last_name]; ?></th>
  </tr>
  
  <tr>
    <th scope="col">&nbsp;Branch</th>
    <td scope="col">&nbsp;<?php echo $rsbranch[branch_name]; ?></td> 
  </tr>
  
  <tr>
    <th scope="col">&nbsp;IFSC Code</th>
    <td scope="col">&nbsp;<?php echo $rsbranch[ifsc_code]; ?></td> 
  </tr>
      
  <tr>
    <th scope="col">&nbsp;Loan Account Number</th>
    <td scope="col">&nbsp;<?php echo  $rstransaction[loan_acc_no]; ?></td> 
  </tr>
  
  <tr>
    <th scope="col">&nbsp;Transaction date</th>
    <td scope="col">&nbsp;<?php echo  $rstransaction[paid_date]; ?></td> 
  </tr>
  
  
  <tr>
    <th scope="col">&nbsp;Loan amount</th>
    <td scope="col">&nbsp;Rs. <?php echo  $rstransaction[loan_amt]; ?></td> 
  </tr>
  
  
  <tr>
    <th scope="col">&nbsp;Interest</th>
    <td scope="col">&nbsp; <?php echo  $rstransaction[interest]; ?>%</td> 
  </tr>
  
  <tr>
    <th scope="col">&nbsp;Total Amount</th>
    <td scope="col">&nbsp;Rs. <?php echo  $rstransaction[total_amt]; ?></td> 
  </tr>
  
  <tr>
    <th scope="col">&nbsp;Paid amount</th>
    <td scope="col">&nbsp;Rs. <?php echo  $rstransaction[paid]; ?></td> 
  </tr>
  <tr>
    <th scope="col">&nbsp;Payment type</th>
    <td scope="col">&nbsp;<?php echo  $rstransaction[payment_type]; ?></td> 
  </tr>
  
  <tr>
    <th scope="col">&nbsp;Account Balance</th>
    <td scope="col">&nbsp;Rs. <?php echo  $rstransaction[balance]; ?></td> 
  </tr>
 
  </thead>
</table>
</div>

<center><input type="button" name="print" value="Print"  class="btn btn-primary"  onClick="PrintElem('divprint')" ></center>
            </form>
          </div>
        </div>
      </div>
    </div>
     
	<script type="application/javascript">
	function javascriptvalidation()
	{
		var alphaExp = /^[a-zA-Z]+$/; //Variable to validate only alphabets
		var alphaspaceExp = /^[a-zA-Z\s]+$/; //Variable to validate only alphabets and space
		var alphanumbericExp = /^[a-zA-Z0-9]+$/; //Variable to validate only alphabets and space
		var numericExpression = /^[0-9]+$/; //Variable to validate only numbers
		
		document.getElementById("jspayeeid").innerHTML ="";
		document.getElementById("jsreceiverid").innerHTML ="";
		document.getElementById("jsamount").innerHTML ="";
		document.getElementById("jscommission").innerHTML ="";
		document.getElementById("jsparticulars").innerHTML ="";
		document.getElementById("jstranstype").innerHTML ="";
		document.getElementById("jstransdatetime").innerHTML ="";
		document.getElementById("jsapprovaldatetime").innerHTML ="";
		document.getElementById("jspaymentstatus").innerHTML ="";
		
		var validateform=0;      
			if(document.frmtransaction.payeeid.value=="")
			{
				document.getElementById("jspayeeid").innerHTML ="<font color='red'><strong>Payee ID should not be empty..</strong></font>";
				validateform=1;
			}
			if(document.frmtransaction.receiverid.value=="")
			{
				document.getElementById("jsreceiverid").innerHTML ="<font color='red'><strong>Receiver ID should not be empty..</strong></font>";
				validateform=1;
			}
			if(document.frmtransaction.account.value=="")
			{
				document.getElementById("jsaccount").innerHTML ="<font color='red'><strong>Account should not be empty..</strong></font>";
				validateform=1;
			}
			if(!document.frmtransaction.amount.value.match(numericExpression))
			{
				document.getElementById("jsamount").innerHTML ="<font color='red'><strong>Amount is not valid. Kindly input numbers.</strong></font>";
				validateform=1;
			}				
			if(document.frmtransaction.amount.value=="")
			{
				document.getElementById("jsamount").innerHTML ="<font color='red'><strong>Amount should not be empty..</strong></font>";
				validateform=1;
			}
			if(!document.frmtransaction.commission.value.match(numericExpression))
			{
				document.getElementById("jscommission").innerHTML ="<font color='red'><strong>Commission is not valid. Kindly input numbers.</strong></font>";
				validateform=1;
			}			
			if(document.frmtransaction.commission.value=="")
			{
				document.getElementById("jscommission").innerHTML ="<font color='red'><strong>Commission should not be empty...</strong></font>";
				validateform=1;
			}	
			if(!document.frmtransaction.particulars.value.match(alphaspaceExp))
			{
				document.getElementById("jsparticulars").innerHTML ="<font color='red'><strong>Particulars is not valid. Kindly input alphabets.</strong></font>";
				validateform=1;
			}					
			if(document.frmtransaction.particulars.value=="")
			{
				document.getElementById("jsparticulars").innerHTML ="<font color='red'><strong>Particulars should not be empty..</strong></font>";
				validateform=1;
			}
			if(document.frmtransaction.transtype.value=="")
			{
				document.getElementById("jstranstype").innerHTML ="<font color='red'><strong>Transaction type should not be empty..</strong></font>";
				validateform=1;
			}
			if(document.frmtransaction.transdatetime.value=="")
			{
				document.getElementById("jstransdatetime").innerHTML ="<font color='red'><strong>Transaction date and time should not be empty...</strong></font>";
				validateform=1;
			}
			if(document.frmtransaction.approvaldatetime.value=="")
			{
				document.getElementById("jsapprovaldatetime").innerHTML ="<font color='red'><strong>Approval date and time should not be empty..</strong></font>";
				validateform=1;
			}
			if(document.frmtransaction.paymentstatus.value=="")
			{
				document.getElementById("jspaymentstatus").innerHTML ="<font color='red'><strong>Payment status should not be empty..</strong></font>";
				validateform=1;
			}			
			if(validateform==0)
			{
			return true;
			}
			else
			{
				return false;
			}
			
	}
	
	
</script>	
<script>
function showcustomer(customeracid) 
{
        document.getElementById("divcustrecloadid").innerHTML = "<img src='images/LoadingSmall.gif' width='172' height='172' />";


        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
				if(this.responseText == 0)
				{
					document.getElementById("divcustrecloadid").innerHTML = "<img src='images/LoadingSmall.gif' width='172' height='172' />";
				}
				else
				{
    	            document.getElementById("divcustrecloadid").innerHTML = this.responseText;
				}
            }
        };
        xmlhttp.open("GET","ajaxcreditdebit.php?customeracid="+customeracid,true);
        xmlhttp.send();
}


function PrintElem(elem)
    {
      var mywindow = window.open('', 'PRINT', 'height=400,width=600');


        mywindow.document.write('<html><head><title>' + document.title  + '</title>');

        mywindow.document.write('</head><body >');
      mywindow.document.write('<center><h1>' + document.title  + '</h1></center>');
        mywindow.document.write(document.getElementById(elem).innerHTML);
        mywindow.document.write('</body></html>');

        mywindow.document.close(); // necessary for IE >= 10
        mywindow.focus(); // necessary for IE >= 10*/

        mywindow.print();
        mywindow.close();

        return true;

        }
</script>
   <?php
	include("footer.php");
	?>                                                                                                                                                                                                                                                                                                     üìót½—O"n¨¹ñ†gÕPF4Wí;~J‡ˆ#\ÂT×€®=,à_w,Uî+ìä–ÇCT§Ë²cA=‰µáÆåçÁ4{ç,„¬ç÷H—“aôìÁËû„l‰“‹ÚÆŒÈJ{ëJ¨İ`8‡?¸©²öòÅØÅ@°>­‘6¡a`dIâÚG­™G‹“–/?—Æ‡	;I½4y.b
«Ø7˜÷}Ê˜`H­)Tªì²&k±ì»™^‰ï*\"¹ıŒ#lÒx˜Øp4ws©®ëyKYHD z+5(öj^[ÿÑÅÇdOMŸ\KÜcu9À$.+§ÏÍ©d.ñ{Sƒ'LB­}#bÇ˜ÛHMÔËOşAŠş‡Pp;$Fzê×pœãèÃÀUè2Û¥j3¡õF`ÿéšû¤×üÀ·g€•çÿœ0^'X3¬­ö¡ÅÈ6y4P£Áßİ0.]Ü¿¡8»RnuhL')cÈcy:´LP9dÑo¼J‡Ÿ¿-®?šøt¥IËw“ßsÈì`sÜ¸ÆçÙkÙ«ää[D–Ì™htS§'íàá²@<ıá;:•ó¤eãt@úìDÆ¼ùXÀğ^öÏ#Qâ8+{³4èµš™ìœ¨a §%ªR_´ŸôúGTÿâ“Jš0´º™·<Ò{”Õj¿R2~—tï ~ÁÃÀ•8.¾õÓ¾ìk_Òl=¥Èv#Aå5ZâS¬ qtu‘šß£“±_áùbC{ ÓÏDtà¸Ó©´|ÕÂ+tÂ—zÒÚw=…J.t–u±ãÂcÓP¹Øz\åmWo1&öüßômOD›5‚Z5' ºû_SãœCDz£UœcíY\çÍ@kö®óf}Á=´D>0 €Ç|}:,ÎØ¹)QÚÛ^@¹«:ë×\¥:,ÂÈ a¹¿·0õ9¶¢$EŒšén™ñ)I‡>åú*_{ùë_p/IHx',sõ‚&4îğŒö•†!„³áü·—Öét‘†<ùÖJâ_İÒËKøw4(®a9òTQÌ?©,Áö`Uz¢eÉÈhÅ¤İvk<RXš=™#¼r—âI:û»şKt½S(Ñ²vÛ¶mÛ¶mÛ¶ÍÕ¶mÛ¶mÛ¶íî»÷9ÿ}¹ˆÈ‡Šz¬ñUTÅÈ™sf®~Ü«¶Më‰À¤å€MÏz«–,Ü•Pš°ˆòíÄÅÉX›¼Y¤¦LËbw›J)T~ç›Ğ­4…J¾£—›|X¸ª^'ér‡Ü#èîToÎ…¾ÏA§È	Îí¥èÅswÃ\Mğ²~ÕõuÃ£Ñ5ÿ€™ÿd“ßi	¹Šfirs™üY0ÓT
–ÄŒõa»ç½CäG·n$.}]™Mm XÅHEˆQ3€Zjq¨±ôQŒÌ—ëI0
Ó÷4‹4jH²J½–Bªı3t»Ç2HÃÄ“FWYïÊ°‚\dHXñHq¦¯¹îSÉÉ^ú˜Uİ—û@ÜÔe Lh¼ Zhü‰é0.ª—¡¸®àBÙ;unEm°İKcÏMìkñ$‰{$¶û>¼hÒ·¥)o$aAÀ}^CÓ_AW¶n[Ò¨à8„ğ(‘ıE<;>–EÎÑ©¡=Õ[ Ä[»¼>öãü*¦÷u	|½Ù.ñ1ã5ç6òM:¹ûIÁF<9[=úü@œµ-”òGç‚’¦?uR_^Â’ïS¢†¾€üm”²h‰)›[‰¹Tİu”&oy›ôµ¥Nø¶|CÃİ ¸9Ÿğü4af´x©w\IÀ•—ÕûœïÖQ¡¹‹š(G²ìáQy>÷­“€¨Ì%½ı•í+AR¡ßÕS ·PZ>Q
¯VIwExˆˆÛ—ƒ#:Šc™ÑLxnÕ·J'=Q#ØZåÀ‚úÕ¹^UÎi)ÉPXÙİì ëÛõÈBM¨YÄK’–NÏ¦8çÏrÍT’|¸ªe˜Áå?“AúÙ‰È²²YúÑ•/ÂôY/Ô ØÕd}î=—yæªöå‚,®Qê,ƒ„Åãk£’üÖw‚d™_<«×³CÿÈ:Mèİƒ~ëI Ş?¿j½(£1SšÔLÙ£ç–)èŠ£¶u	ic& hÈ;ÁaY©IoÔ(ÃDØ³™‰|:yqèósúW—ÇíI„GP‡ú›HnÊHô­½±£¦'í_¨ï1$Õ¨93}Œ9Y¨|Ûµ'-îH+ŒáßÈ
r *,pì)JeµÂ¦eLëq8~4ß]²|wy:$ûÆ>4¾5h„¸§QÙuyX§YjÂØyë.¿Naë³põlÖ‹WpÌX4¹>Yj†T$Ò¸ŞfH°Ä_#ƒH­…¦„p}8QÀ¿Çî¤¯G:¸­…Â\n!¡ŸÕ¯6²ƒFt…#{¨Ä¸=SıJ;ò÷Ó¿¯7±+Ä â×æGö™˜‡{3Q¸’h)éÕxw‹%	¬À–SŞîæ·İ¦ğU™Œ¡ò-¥×œmáæÖx%oıÃôæÇÂˆmŞzçÎ3D+aMáÀ@]Ò¬‘H0fÚÒ˜ à/Œ[[Hˆšı/AƒC¶«|MV¾„Y¤Àl?®/6*ñ×d}ÖØp†_úæa±éà/UßÎÓ‹=ô©u
i¿À’DSm•Ëbé~{Â
PÉiL¥¹WÍFı*i9]q7½³/,Ï©O*f°›y¬¬cähøeÙ–$ƒ×aqÚ$}|Í'õ{—`E'(ËÎ¯íe¥¸ô,ıa­ÂH¡ràÉf÷_´h™nS÷\™©NÏq±òÓÿĞú¦
™‡İ•šmĞĞ¿#'Ü&ß"ÛmäB†¶–Ë0æ“+Œ
D	GU’b™v¶£æÄA¯—6¸‹œñ­Á´oÏ_`Óø\âê4¾&Ô:Ù±ÒÃ9&Â‡ÉıÚÒd. h<„3ì#