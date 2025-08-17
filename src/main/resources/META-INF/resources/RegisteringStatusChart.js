fetch('/api/registeringStatus')
  .then(res =>  res.json()
    .then(data => {
      const canvas = document.getElementById('myChart');
      if (!canvas) { console.error('Canvas not found'); return; }
      const ctx = canvas.getContext('2d');
      if (!ctx) { console.error('2d ctx not found'); return; }

      // اگر قبلاً یک چارت ساخته شده، آن را پاک کن (در حالت reload)
      if (window._myChart) {
        window._myChart.destroy();
        window._myChart = null;
      }

      window._myChart = new Chart(ctx, {
        type: 'bar' +
          '' +
          '',
        data: {
          labels: data.labels || [],
          datasets: [{
            label: 'وضعیت ثبت نام',
            data: data.values || [],
            backgroundColor: ['rgba(255,99,132,0.2)','rgba(98,213,68,0.2)','rgba(255,206,86,0.2)','rgba(83,192,75,0.2)','rgba(80,162,235,0.2)'],
            borderColor: ['rgb(151,40,40)','rgb(200,12,35)','rgba(255,206,86,1)','rgba(75,192,192,1)'],
            borderWidth: 1
          }]

        },
          options: {
            scales: {
              y: {
                ticks: {
                  precision: 0
                }
              }
            }
          }
        }
      );
    })
  )
