import React from "react";
import { Table } from "react-bootstrap";
import Nav from "./Nav";

function Home({ Toggle, Title, data }) {
  // Directly set data without fetching or loading state
 console.log(data);
 console.log(Title);
  const renderTable = () => {
    if (!data) {
      return <div>Loading...</div>; // Show loading message while data is being fetched
    }
    if (Title === "Users Information") {
      return (
        <Table className="table caption-top rounded mt-2" striped>
          <caption className="text-white fs-4">List of Users</caption>
          <thead>
            <tr>
              <th>#</th>
              <th>Name</th>
              <th>Email</th>
              <th>Password</th>
            </tr>
          </thead>
          <tbody>
            {data.length === 0 ? (
              <tr>
                <td colSpan="4">No users available</td>
              </tr>
            ) : (
              data.map((user) => (
                <tr key={user.id}>
                  <td>{user.id}</td>
                  <td>{user.name}</td>
                  <td>{user.email}</td>
                  <td>{user.password}</td>
                </tr>
              ))
            )}
          </tbody>
        </Table>
      );
    }

    if (Title === "Accounts Information") {
      return (
        <Table className="table caption-top rounded mt-2" striped>
          <caption className="text-white fs-4">List of Accounts</caption>
          <thead>
            <tr>
              <th>#</th>
              <th>Account Number</th>
              <th>Balance</th>
              <th>Account Type</th>
            </tr>
          </thead>
          <tbody>
            {data.length === 0 ? (
              <tr>
                <td colSpan="4">No accounts available</td>
              </tr>
            ) : (
              data.map((account) => (
                <tr key={account.id}>
                  <td>{account.id}</td>
                  <td>{account.accountNumber}</td>
                  <td>{account.balance}</td>
                  <td>{account.accountType}</td>
                </tr>
              ))
            )}
          </tbody>
        </Table>
      );
    }

    if (Title === "Transactions Information") {
      return (
        <Table className="table caption-top rounded mt-2" striped>
          <caption className="text-white fs-4">List of Transactions</caption>
          <thead>
            <tr>
              <th>#</th>
              <th>Transaction ID</th>
              <th>Amount</th>
              <th>Transaction Type</th>
            </tr>
          </thead>
          <tbody>
            {data.length === 0 ? (
              <tr>
                <td colSpan="4">No transactions available</td>
              </tr>
            ) : (
              data.map((transaction) => (
                <tr key={transaction.id}>
                  <td>{transaction.id}</td>
                  <td>{transaction.transactionId}</td>
                  <td>{transaction.amount}</td>
                  <td>{transaction.transactionType}</td>
                </tr>
              ))
            )}
          </tbody>
        </Table>
      );
    }

    return null; // If no title matches
  };

  return (
    <div className="px-3">
      <Nav Toggle={Toggle} />
      <div className="container-fluid">
        <div className="row g-3 my-2">
          {/* Example of other UI elements */}
          {[...Array(4)].map((_, index) => (
            <div className="col-md-3 p-1" key={index}>
              <div className="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                <div>
                  <h3 className="fs-2">230</h3>
                  <p className="fs-5">Total</p>
                </div>
                <i className="bi bi-activity p-3 fs-1"></i>
              </div>
            </div>
          ))}
        </div>
      </div>

      {/* Render the appropriate table based on Title */}
      {renderTable()}
    </div>
  );
}

export default Home;
