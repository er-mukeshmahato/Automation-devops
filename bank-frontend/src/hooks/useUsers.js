import { getUsers } from '../api';  // This imports all API functions re-exported from index.js

// Example of using the getUsers function
getUsers().then((response) => {
  console.log(response.data);
}).catch((error) => {
  console.error('Error fetching users:', error);
});