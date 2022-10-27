import React from 'react';
import { useNavigate } from 'react-router-dom';

const NoticeRow = (props) => {

  let navigate = useNavigate();

  return (
    <>
      <tr>
        <td>{props.notice.NOTICE_NO}</td>
        <td onClick={()=>{ navigate('/notice/detail/'+props.notice.NOTICE_NO)}} id="list-title">
          [{props.notice.NOTICE_CATEGORY}] &nbsp;
          {props.notice.NOTICE_TITLE}
        </td>
        <td>{props.notice.NOTICE_WRITER}</td>
        <td>{props.notice.NOTICE_REGDATE}</td>
        <td>{props.notice.NOTICE_HIT}</td>
      </tr>
    </>
  );
};

export default NoticeRow;