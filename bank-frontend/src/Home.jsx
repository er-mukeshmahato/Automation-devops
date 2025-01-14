import React from "react";
import Nav from "./Nav";
import { Table } from 'react-bootstrap';

function Home({Toggle}) {
  return (
    <div className="px-3">
      <Nav Toggle={Toggle} />
      <div className="container-fluid">
        <div className="row g-3 my-2">
          <div className="col-md-3 p-1">
            <div className="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
              <div>
                <h3 className="fs-2">230</h3>
                <p className="fs-5">Products</p>
              </div>
              <i className="bi bi-cart-plus p-3 fs-1"></i>
            </div>
          </div>
          <div className="col-md-3 p-1">
              <div className="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                <div>
                  <h3 className="fs-2">230</h3>
                  <p className="fs-5">Products</p>
                </div>
                <i className="bi bi-cart-plus p-3 fs-1"></i>
              </div>
            </div>
            <div className="col-md-3 p-1">
              <div className="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                <div>
                  <h3 className="fs-2">230</h3>
                  <p className="fs-5">Products</p>
                </div>
                <i className="bi bi-cart-plus p-3 fs-1"></i>
              </div>
            </div>
            <div className="col-md-3 p-1">
              <div className="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                <div>
                  <h3 className="fs-2">230</h3>
                  <p className="fs-5">Products</p>
                </div>
                <i className="bi bi-cart-plus p-3 fs-1"></i>
              </div>
            </div>
        </div>
      </div>
      <Table striped="table caption-top rounded mt-2"> 
        <caption className="text-white fs-4">List of users</caption>
      <thead>
        <tr>
          <th>#</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Username</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>Mark</td>
          <td>Otto</td>
          <td>@mdo</td>
        </tr>
        <tr>
          <td>2</td>
          <td>Jacob</td>
          <td>Thornton</td>
          <td>@fat</td>
        </tr>
        <tr>
          <td>3</td>
          <td colSpan={2}>Larry the Bird</td>
          <td>@twitter</td>
        </tr>
      </tbody>
    </Table>
    </div>
  );
}

export default Home;
