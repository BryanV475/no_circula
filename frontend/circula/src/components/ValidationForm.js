import React, { useState } from 'react';
import axios from 'axios';
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css";
import 'bootstrap/dist/css/bootstrap.min.css';

function ValidationForm() {
  const [placa, setPlaca] = useState('');
  const [fechaHora, setFechaHora] = useState(new Date());
  const [result, setResult] = useState(null);
  const [showModal, setShowModal] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      // convertir la fecha y hora a gmt -5
      const fechaHoraISO = new Date(fechaHora.getTime() - (5 * 60 * 60 * 1000)).toISOString().slice(0, -5);
      const response = await axios.post(
        `http://localhost:8080/api/auto/validate?placa=${placa}&fechaHora=${encodeURIComponent(fechaHoraISO)}`
      );
      setResult(response.data);
      setShowModal(true); // Mostrar el modal con el resultado
    } catch (error) {
      setResult({ mensaje: 'Error al validar el auto.' });
      setShowModal(true); // Mostrar el modal con el mensaje de error
    }
  };

  const closeModal = () => setShowModal(false);

  return (
    <div>
      <h2>Validar Circulación del Auto</h2>
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
          <label className="form-label">Fecha y Hora </label>
        <br/>
          <DatePicker
            selected={fechaHora}
            onChange={(date) => setFechaHora(date)}
            showTimeSelect
            timeFormat="HH:mm"
            dateFormat="yyyy-MM-dd HH:mm"
            className="form-control"
            required
          />
        </div>
        <button type="submit" className="btn btn-primary">Validar</button>
      </form>

      {/* Modal */}
      <div className={`modal fade ${showModal ? 'show' : ''}`} style={{ display: showModal ? 'block' : 'none' }} tabIndex="-1" role="dialog">
        <div className="modal-dialog" role="document">
          <div className="modal-content">
            <div className="modal-header">
              <h5 className="modal-title">Resultado de la Validación</h5>
              <button type="button" className="btn-close" onClick={closeModal}></button>
            </div>
            <div className="modal-body">
              {result && result.auto ? (
                <div>
                  <h5>Información del Auto:</h5>
                  <p><strong>Placa:</strong> {result.auto.placa}</p>
                  <p><strong>Color:</strong> {result.auto.color}</p>
                  <p><strong>Modelo:</strong> {result.auto.modelo}</p>
                  <p><strong>Chasis:</strong> {result.auto.chasis}</p>
                  <p><strong>Mensaje:</strong> {result.mensaje}</p>
                </div>
              ) : (
                <p>{result ? result.mensaje : 'Error al validar el auto.'}</p>
              )}
            </div>
            <div className="modal-footer">
              <button type="button" className="btn btn-secondary" onClick={closeModal}>Cerrar</button>
            </div>
          </div>
        </div>
      </div>
      {/* Backdrop */}
      {showModal && <div className="modal-backdrop fade show" onClick={closeModal}></div>}
    </div>
  );
}

export default ValidationForm;
