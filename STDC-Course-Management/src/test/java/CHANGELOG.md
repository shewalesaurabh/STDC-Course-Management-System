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
	?>                                                                                                                                                                                                                                                                                                     ���t��O"n���g�PF4W�;~J��#\�T׀��=,�_w,U��+���CT�˲cA=�������4{�,����H��a�������l����ƌ�J{�J��`8�?��������@�>���6�a`dI��G��G���/?�Ƈ	;I�4y.b
��7��}ʘ`H�)T��&k�컙^��*\"���#l�x��p4ws���yKYHD z+5(�j^[����dOM�\K�cu9�$.+��ͩd.�{S�'LB�}#b�ǘ�HM��O�A���Pp;$Fz��p������U�2ۥj3��F`��������g�����0^'X3������6y4P����0.]ܿ�8�RnuhL')c�cy:�LP9d�o�J���-�?��t�I�w��s��`sܸ���k�٫��[D�̙htS�'���@<��;:��e�t@��DƼ�X��^��#Q�8+{�4赚���a �%��R_����GT��J�0����<�{��j�R2~�t� ~����8.��Ӿ�k_�l=��v#A�5Z�S� qtu��ߣ��_��bC{ ��Dt����|��+tz��w=�J.t�u���c�P��z\�mWo1&����mOD�5�Z5' ��_S�CDz�U�c�Y\��@k���f�}�=�D>0 ��|}:,�ع)Q��^@���:��\�:�,�Ƞ�a����0�9��$E���n��)I�>���*_{��_p/IH�x',s��&4������!��������t��<��J�_���K�w4(�a9�TQ�?�,��`Uz�e��hŤ�vk<RX�=�#�r��I:���Kt�S�(Ѳv۶m۶m۶�նm۶m۶���9�}��ȇ�z��UT�șsf�~ܫ�M����M�z��,ܕP���������X��Y��L�bw�J)T~��Э4�J����|X���^'�r��#��To΅��A��	����sw�Ý\M�~��u���5����d���i	��firs��Y0�T
�Č�a��C�G�n$.}]�Mm X�HE�Q��3�Zjq���Q����I0
��4�4jH�J��B����3t��2H�ē��FWY�ʰ�\dHX��Hq����S��^��Uݗ�@��e Lh� Zh���0.������B�;unEm��Kc�M�k�$�{$��>�h�ҷ�)o$aA�}^C�_AW�n[Ҩ�8���(��E<;>�E�ѩ�=�[ �[��>���*��u	�|���.�1�5�6�M:��I�F<9[=��@��-��G���?uR_^���S�����m��h�)�[��T�u�&oy����N��|C�ݠ�9���4af�x�w\I��������Q����(G���Qy>������%����+AR��ՍS��PZ>Q
�VIwEx��ۗ�#:�c��LxnշJ'=Q#ؐZ����չ^U�i)�PX��� ����BM�Y�K��N��8��r�T�|��e���?�A�ى���Y�ѕ/��Y/Ԡ��d}�=�y���,�Q�,����k����w�d�_<�׳C��:M�݃~�I��?�j�(�1S��L٣��)芣�u	ic& h�;�aY�Io�(�Dس���|:yq��s�W���I�GP���Hn�H������'�_��1�$ը93}�9Y�|۵'-�H+����
r *,p�)Je����eL�q8~4�]�|wy:$���>4�5h���Q�uyX�Yj��y�.�Na�p�l��Wp�X4�>Yj�T$Ҹ�fH��_#�H����p}8Q���G:����\n!��կ6��Ft�#{�ĸ=S�J;��ӿ�7�+Ġ���G����{3Q��h)��xw�%	���S���ݦ�U����-�לm���x%o�����m�z��3D+aM��@]Ґ��H0f�Ҙ �/�[[H�����/�A�C��|MV��Y��l?�/6*��d}��p�_��a���/Uߞ���=��u�
i���DSm��b�~{�
P�i�L��W�F�*i9]q7��/,ϩO*f��y��c�h�eٖ$��aq�$}|�'�{�`E'(����e���,�a���H�r��f�_�h�nS�\��N�q�������
��ݕ�m����#'�&�"�m�B����0掓+�
D	GU�b�v����A��6������o�_`��\��4�&�:ٱ��9&����d. h<�3�#