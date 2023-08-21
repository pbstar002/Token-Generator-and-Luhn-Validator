import React, { useState } from 'react';
import './App.css';

function App() {
  const [digits, setDigits] = useState("");
  const [generatedToken, setGeneratedToken] = useState("");
  const [inputToken, setInputToken] = useState("");
  const [isValid, setIsValid] = useState(null);

  const handleGenerateToken = async () => {
    try {
      const response = await fetch('http://localhost:8080/generate', {
        method: 'POST',
        body: digits,
        headers: {
          'Content-Type': 'text/plain',
        },
      });
      const token = await response.text();
      setGeneratedToken(token);
    } catch (error) {
      console.error("Error generating token:", error);
    }
  };

  const handleValidateToken = async () => {
    try {
      const response = await fetch('http://localhost:8081/validate', {
        method: 'POST',
        body: inputToken,
        headers: {
          'Content-Type': 'text/plain',
        },
      });
      const validation = await response.json();
      setIsValid(validation);
    } catch (error) {
      console.error("Error validating token:", error);
    }
  };

  return (
    <div className="App">
      <h1>Token Manager</h1>

      <div>
        <h2>Generate Token</h2>
        <input 
          type="text" 
          placeholder="Enter digits e.g. 24790"
          value={digits}
          onChange={e => setDigits(e.target.value)}
        />
        <button onClick={handleGenerateToken}>Generate</button>
        <p>Generated Token: {generatedToken}</p>
      </div>

      <div>
        <h2>Validate Token</h2>
        <input 
          type="text" 
          placeholder="Enter token e.g. 2249-4472-0279-9420"
          value={inputToken}
          onChange={e => setInputToken(e.target.value)}
        />
        <button onClick={handleValidateToken}>Validate</button>
        <p>Token Validity: {isValid === null ? "Not checked" : isValid ? "Valid" : "Invalid"}</p>
      </div>

    </div>
  );
}

export default App;
