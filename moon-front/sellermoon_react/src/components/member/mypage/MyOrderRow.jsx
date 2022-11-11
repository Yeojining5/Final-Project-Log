import React from 'react';
import { OTD1, OTD2, OTD3 } from './../../../styles/SubStyle';

const MyOrderRow = (props) => {
  return (
    <>
      <tr>
        <OTD1 colSpan={3}>
          주문일자 <strong>{props.order.ORDER_DATE}</strong> &nbsp; &nbsp; &nbsp; 주문번호 <strong>{props.order.ORDER_NO}</strong>
        </OTD1>
      </tr>
      <tr>
        <OTD2>{props.order.MD_NAME}</OTD2>
        <OTD3 id="list-title">
          {props.order.MD_PRICE}
        </OTD3>
        <OTD3>
          <p style={{fontSize: "1.25rem", fontWeight: "600"}}>
            {props.order.DELIVERY_STATUS}
          </p>
        </OTD3>
      </tr>
    </>
  );
};

export default MyOrderRow;