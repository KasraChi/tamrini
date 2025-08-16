//
//
// (async function() {
//   const data = [
//     { year: 2010, count: 10 },
//     { year: 2011, count: 20 },
//     { year: 2012, count: 15 },
//     { year: 2013, count: 25 },
//     { year: 2014, count: 22 },
//     { year: 2015, count: 30 },
//     { year: 2016, count: 28 },
//   ];
//
//   new Chart(
//     document.getElementById('acquisitions'),
//     {
//       type: 'bar',
//       data: {
//         labels: data.map(row => row.year),
//         datasets: [
//           {
//             label: 'Acquisitions by year',
//             data: data.map(row => row.count)
//           }
//         ]
//       }
//     }
//   );
// })();

// function renderChart(dataFromBackend) {
//   const ctx = document.getElementById('acquisitions').getContext('2d');
//   new Chart(ctx, {
//     type: 'bar',
//     data: {
//       labels: dataFromBackend.map(row => row.year),
//       datasets: [{
//         label: 'Acquisitions by year',
//         data: dataFromBackend.map(row => row.count),
//         backgroundColor: 'rgba(54, 162, 235, 0.5)'
//       }]
//     }
//   });
// }

// fetch('/api/chart-data')
//   .then(res => res.json())
//   .then(data => {
//     new Chart(document.getElementById('myChart'), {
//       type: 'bar',
//       data: data
//     });
//   });

// window.addEventListener('load', () => {
//   const ctx = document.getElementById('myChart').getContext('2d');
//   new Chart(ctx, {
//     type: 'bar',
//     data: {
//       labels: ['Red', 'Blue', 'Yellow', 'Green'],
//       datasets: [{
//         label: 'Test Data',
//         data: [5, 12, 8, 3], // داده‌ی ساختگی
//         backgroundColor: ['red', 'blue', 'yellow', 'green']
//       }]
//     }
//   });
// });

// window.addEventListener('load', () => {
//   fetch('/api/platforms')
//     .then(res => res.json())
//     .then(data => {
//       const ctx = document.getElementById('myChart').getContext('2d');
//       new Chart(ctx, {
//         type: 'bar',
//         data: {
//           labels: data.labels,
//           datasets: [{
//             label: 'students platforms',
//             data: data.values,
//             backgroundColor: ['red', 'blue', 'yellow', 'green']
//           }]
//         }
//       });
//     })
//     .catch(err => console.error('Error loading chart data:', err));
// });

// fetch('/api/platforms')
// .then(response => response.json())
//   .then(data => {
//     const ctx = document.getElementById('myChart').getContext('2d');
//     new Chart(ctx, {
//       type: 'doughnut',
//       data: {
//         labels: data.labels,
//         datasets: [{
//           label: 'Usage',
//           data: data.values,
//           backgroundColor: 'rgba(75, 192, 192, 0.2)',
//           borderColor: 'rgb(54,137,72)',
//           borderWidth: 1
//         }]
//       },
//       options: {
//         scales: {
//           y: { beginAtZero: true }
//         }
//       }
//     });
//   });

// console.log('PlatformChart.js loaded');
//
// window.addEventListener('load', function () {
//   console.log('PlatformChart.html loaded; fetching data...');
//
//   fetch('/api/platforms')
//     .then(res => {
//       console.log('api response status', res.status);
//       return res.json();
//     })
//     .then(data => {
//       console.log('api data:', data); // مهم: ببین data خالی نیست
//       const canvas = document.getElementById('myChart');
//       if (!canvas) { console.error('Canvas not found'); return; }
//       const ctx = canvas.getContext('2d');
//       if (!ctx) { console.error('2d ctx not found'); return; }
//
//       // اگر قبلاً یک چارت ساخته شده، آن را پاک کن (در حالت reload)
//       if (window._myChart) {
//         window._myChart.destroy();
//         window._myChart = null;
//       }
//
//       window._myChart = new Chart(ctx, {
//         type: 'doughnut',
//         data: {
//           labels: data.labels || [],
//           datasets: [{
//             label: 'Usage',
//             data: data.values || [],
//             backgroundColor: ['rgba(255,99,132,0.2)','rgba(54,162,235,0.2)','rgba(255,206,86,0.2)','rgba(75,192,192,0.2)'],
//             borderColor: ['rgba(255,99,132,1)','rgba(54,162,235,1)','rgba(255,206,86,1)','rgba(75,192,192,1)'],
//             borderWidth: 1
//           }]
//         },
//         options: {
//           responsive: true,
//           maintainAspectRatio: false,
//           scales: {
//             y: { beginAtZero: true }
//           }
//         }
//       });
//
//       console.log('chart created');
//     })
//     .catch(err => {
//       console.error('Error loading chart data:', err);
//     });
// });
//



  fetch('/api/platforms')
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
        type: 'doughnut' +
          '' +
          '',
        data: {
          labels: data.labels || [],
          datasets: [{
            label: 'تعداد استفاده از پیامرسان ها',
            data: data.values || [],
            backgroundColor: ['rgba(255,99,132,0.2)','rgba(54,162,235,0.2)','rgba(255,206,86,0.2)','rgba(83,192,75,0.2)','rgba(80,162,235,0.2)'],
            borderColor: ['rgba(255,99,132,1)','rgba(54,162,235,1)','rgba(255,206,86,1)','rgba(75,192,192,1)'],
            borderWidth: 1
          }]
        },
      });

    })
   )



