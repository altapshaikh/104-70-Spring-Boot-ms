import React, { useEffect, useState } from "react";
import { getEmployees, deleteEmployee } from "../services/api";

const employeeList = () => {
  const [employee, setEmployee] = useState([]);

  useEffect(() => {
    loadEmployee();
  }, []);

  const loadEmployee = async () => {
    const result = await getEmployees();
    setEmployee(result.data);
  };

  const handleDelete = async (id) => {
    await deleteEmployee(id);
    loadEmployee();
  };

  return (
    <div>
      <h2>Employee List</h2>
      <ul>
        {employee.map(e => (
          <li key={e.id}>
            {e.name} - {e.email}
            <button onClick={() => handleDelete(e.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default EmployeeList;
