import React from "react";

function Sidebar() {
  return (
    <div className="bg-white sidebar ps-2">
      <div className="m-2">
        <i className="bi bi-bootstrap-fill me-2 fs-4"></i>
        <span className="brand-name fs-4">Bank</span>
      </div>
      <hr className="text-dark" />
      <div className="list-group list-group-flush">
        <a className="list-group-item py-2" href="/admin/dashboard">
          <i className="bi bi-speedometer2 me-2 fs-5"></i>
          <span >Dashboard</span>
        </a>
        <a className="list-group-item py-2" href="/admin/user-page">
          <i className="bi bi-people fs-5 me-2"></i>
          <span >User</span>
        </a>
        <a className="list-group-item py-2" href="/admin/accounts">
          <i className="bi bi-bank fs-5 me-2"></i>
          <span >Account</span>
        </a>
        <a className="list-group-item py-2" href="/admin/transaction">
          <i className="bi bi-house fs-5 me-2"></i>
          <span >Transaction</span>
        </a>
        <a className="list-group-item py-2" href="/admin/report">
          <i className="bi bi-clipboard fs-5 me-2"></i>
          <span >Report </span>
        </a>
        <a className="list-group-item py-2" href="/">
          <i className="bi bi-person-circle fs-5 me-2"></i>
         
          <span >Profile </span>
        </a>
        <a className="list-group-item py-2" href="/">
          <i className="bi bi-power fs-5 me-2"></i>
          <span >Logout </span>
        </a>
      </div>
    </div>
  );
}

export default Sidebar;
