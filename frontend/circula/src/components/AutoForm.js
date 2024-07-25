import React, { useState } from 'react';
import axios from 'axios';

function AutoForm() {
    const [placa, setPlaca] = useState('');
    const [color, setColor] = useState('');
    const [modelo, setModelo] = useState('');
    const [chasis, setChasis] = useState('');
    const [message, setMessage] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/auto', {
                placa,
                color,
                modelo,
                chasis
            });
            setMessage(`Auto creado con ID: ${response.data.id}`);
        } catch (error) {
            setMessage('Error al crear el auto.');
        }
    };

    return (
        <div>
            <h2>Registrar Auto</h2>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label className="form-label">Placa</label>
                    <input
                        type="text"
                        className="form-control"
                        value={placa}
                        onChange={(e) => setPlaca(e.target.value)}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Color</label>
                    <input
                        type="text"
                        className="form-control"
                        value={color}
                        onChange={(e) => setColor(e.target.value)}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Modelo</label>
                    <input
                        type="text"
                        className="form-control"
                        value={modelo}
                        onChange={(e) => setModelo(e.target.value)}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label">Chasis</label>
                    <input
                        type="text"
                        className="form-control"
                        value={chasis}
                        onChange={(e) => setChasis(e.target.value)}
                        required
                    />
                </div>
                <button type="submit" className="btn btn-primary">Registrar Auto</button>
            </form>
            {message && <div className="mt-3 alert alert-info">{message}</div>}
        </div>
    );
}

export default AutoForm;
