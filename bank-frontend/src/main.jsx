import React from 'react'
import ReactDOM from 'react-dom/client'
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-icons/font/bootstrap-icons.css';
import './index.css'
import App from './App'
import { QueryClient, QueryClientProvider } from '@tanstack/react-query'
import Dashboard from './Dashboard'

const root = ReactDOM.createRoot(document.getElementById('root'))
const queryClient = new QueryClient();
root.render(
  <QueryClientProvider client={queryClient}>
  <App />
</QueryClientProvider>,
)