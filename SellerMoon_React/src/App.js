import { Route, Routes } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import "./App.css"
import axios from "axios"
import Main from './components/main_member/Main';
import Notice from './components/notice/Notice';
import NoticeDetail from './components/notice/NoticeDetail';
import NoticeAdmin from './components/notice/NoticeAdmin';
import NoticeUpAdmin from './components/notice/NoticeUpAdmin';
import Faq from './components/faq/Faq';
import FaqDetail from './components/faq/FaqDetail';
import FaqAdmin from "./components/faq/FaqAdmin";
import FaqUpAdmin from './components/faq/FaqUpAdmin';


function App() {


  return (
    <>
      <Routes>

        <Route path="*" element={<h1>잘못된 경로입니다😕</h1>}/> {/* 404페이지 */}

        <Route path="/" element={<Main />} exact={true} />
        
        <Route path="/notice" element={<Notice />} exact={true} />
        <Route path="/notice/detail/:notice_no" element={<NoticeDetail />} exact={true} />
        <Route path="/admin/notice" element={<NoticeAdmin />} exact={true} />
        <Route path="/admin/notice/update/:notice_no" element={<NoticeUpAdmin />} exact={true} />
      
        <Route path="/faq" element={<Faq />} exact={true} />
        <Route path="/faq/detail/:faq_no" element={<FaqDetail />} exact={true} />
        <Route path="/admin/faq" element={<FaqAdmin />} exact={true} />
        <Route path="/admin/faq/update/:faq_no" element={<FaqUpAdmin />} exact={true} />

      </Routes>
    </>
  );
}

export default App;