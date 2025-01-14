// src/hooks/useUsers.js
import { useQuery } from '@tanstack/react-query';
import { getUsers } from '../api';  // Import the getUsers API function

// Custom hook to fetch users
const useUsers = () => {
  return useQuery(['users'], getUsers);  // React Query hook for fetching users
};

export default useUsers;
