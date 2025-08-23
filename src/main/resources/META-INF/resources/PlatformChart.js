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
// window.addEventListener("message", function(event) {
//   console.log("salam")
// const classCode = event.data;
// if (classCode) return;


// window.addEventListener('message', function(event) {
//   const classCode = event.data;
//   if (typeof classCode === 'string') {
//     fetchChartData(classCode);
//   }
// });
// function fetchChartData(classCode) {
//   fetch(`/api/platforms/${classCode}`)
//     .then(res => res.json())
//     .then(data => {
//       console.log("salam 2");
//
//       const canvas = document.getElementById('myChart');
//       if (!canvas) {
//         console.error('Canvas not found');
//         return;
//       }
//
//       const ctx = canvas.getContext('2d');
//       if (!ctx) {
//         console.error('2D context not found');
//         return;
//       }
//
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
//             label: 'تعداد استفاده از پیامرسان ها',
//             data: data.values || [],
//             backgroundColor: [
//               'rgba(255,99,132,0.2)',
//               'rgba(54,162,235,0.2)',
//               'rgba(255,206,86,0.2)',
//               'rgba(83,192,75,0.2)',
//               'rgba(80,162,235,0.2)'
//             ],
//             borderColor: [
//               'rgba(255,99,132,1)',
//               'rgba(54,162,235,1)',
//               'rgba(255,206,86,1)',
//               'rgba(75,192,192,1)'
//             ],
//             borderWidth: 1
//           }]
//         }
//       });
//     });
// }


// window.addEventListener('message', function(event) {
//   const classCode = event.data;
//   if (typeof classCode === 'string') {
//     fetchChartData(classCode);
//   }
// });
//
// function fetchChartData(classCode) {
//   fetch(`/api/platforms/${classCode}`)
//     .then(res => res.json())
//     .then(data => {
//       const canvas = document.getElementById('myChart');
//       if (!canvas) {
//         console.error('Canvas not found');
//         return;
//       }
//       const ctx = canvas.getContext('2d');
//       if (!ctx) {
//         console.error('2D context not found');
//         return;
//       }
//       if (window._myChart) {
//         window._myChart.destroy();
//         window._myChart = null;
//       }
//
//       const backgroundColors = [
//         '#1498dd', // قرمز
//         '#eb3675', // آبی
//         '#FFCE56', // زرد
//         '#4BC0C0', // سبز-آبی
//         '#9966FF', // بنفش
//         '#FF9F40'  // نارنجی
//       ];
//
//       const borderColors = backgroundColors.map(c => shadeColor(c, -20));
//
//       window._myChart = new Chart(ctx, {
//         type: 'doughnut',
//         data: {
//           labels: data.labels || [],
//           datasets: [{
//             label: 'تعداد استفاده از پیامرسان ها',
//             data: data.values || [],
//             backgroundColor: backgroundColors,
//             borderColor: borderColors,
//             borderWidth: 2,
//             hoverOffset: 30
//           }]
//         },
//         options: {
//           responsive: true,
//           maintainAspectRatio: false,
//           cutout: '70%', // حلقه پهن‌تر، ظاهری مدرن‌تر
//           animation: {
//             animateRotate: true,
//             animateScale: true
//           },
//           plugins: {
//             legend: {
//               position: 'bottom',
//               labels: {
//                 font: {
//                   size: 14,
//                   family: '\'Vazirmatn\', sans-serif'
//                 },
//                 color: '#444',
//                 padding: 20,
//                 usePointStyle: true,
//                 pointStyle: 'circle'
//               }
//             },
//             tooltip: {
//               enabled: true,
//               backgroundColor: 'rgba(0,0,0,0.7)',
//               titleFont: {
//                 family: '\'Vazirmatn\', sans-serif',
//                 size: 16,
//                 weight: 'bold'
//               },
//               bodyFont: {
//                 family: '\'Vazirmatn\', sans-serif',
//                 size: 14
//               },
//               padding: 10,
//               cornerRadius: 8,
//               displayColors: true,
//               callbacks: {
//                 label: context => {
//                   const label = context.label || '';
//                   const value = context.parsed || 0;
//                   return `${label}: ${value.toLocaleString('fa-IR')}`;
//                 }
//               }
//             }
//           }
//         }
//       });
//     });
// }

// // تابع ساده برای تیره کردن رنگ‌ها
// function shadeColor(color, percent) {
//   let f = parseInt(color.slice(1), 16), t = percent < 0 ? 0 : 255, p = percent < 0 ? percent * -1 : percent;
//   let R = f >> 16, G = f >> 8 & 0x00FF, B = f & 0x0000FF;
//   return '#' + (0x1000000 + (Math.round((t - R) * p / 100) + R) * 0x10000 + (Math.round((t - G) * p / 100) + G) * 0x100 + (Math.round((t - B) * p / 100) + B)).toString(16).slice(1);
// }



// Chart.register({
//   id: 'centerText',
//   afterDraw(chart) {
//     const ctx = chart.ctx;
//     const width = chart.width;
//     const height = chart.height;
//
//     ctx.save();
//
//     // پیدا کردن آیتم هاور شده
//     const active = chart.tooltip?.dataPoints;
//     if (active && active.length > 0) {
//       const label = active[0].label;
//
//       ctx.font = 'bold 18px Vazirmatn';
//       ctx.fillStyle = '#333';
//       ctx.textAlign = 'center';
//       ctx.textBaseline = 'middle';
//       ctx.fillText(label, width / 2, height / 2);
//     }
//
//     ctx.restore();
//   }
// });

Chart.register({
  id: 'centerText',
  beforeDraw(chart) {
    const ctx = chart.ctx;
    const width = chart.width;
    const height = chart.height;

    const tooltip = chart.tooltip;
    if (!tooltip || !tooltip.opacity || !tooltip.dataPoints?.length) return;

    const label = tooltip.dataPoints[0].label;
    const value = tooltip.dataPoints[0].parsed;

    ctx.save();
    ctx.font = 'bold 18px Vazirmatn';
    ctx.fillStyle = '#333';
    ctx.textAlign = 'center';
    ctx.textBaseline = 'middle';

    // نمایش label در مرکز
    ctx.fillText(label, width / 2, height / 2 - 10);

    // // نمایش مقدار (value) در زیر label
    // ctx.font = 'normal 14px Vazirmatn';
    // ctx.fillText(value.toLocaleString('fa-IR'), width / 2, height / 2 + 15);

    ctx.restore();
  }
});


window.addEventListener('message', function(event) {
  const classCode = event.data;
  if (typeof classCode === 'string') {
    fetchChartData(classCode);
  }
});

function fetchChartData(classCode) {
  fetch(`/api/platforms/${classCode}`)
    .then(res => res.json())
    .then(data => {
      const canvas = document.getElementById('myChart');
      if (!canvas) {
        console.error('Canvas not found');
        return;
      }
      const ctx = canvas.getContext('2d');
      if (!ctx) {
        console.error('2D context not found');
        return;
      }

      if (window._myChart) {
        window._myChart.destroy();
        window._myChart = null;
      }

      // نگاشت نام لیبل‌ها به رنگ‌های اختصاصی
      const labelColorMap = {
        'T': '#0088cc',
        'B  ': '#10da9f',
        'اینستاگرام': '#C13584',
        'فیسبوک': '#3b5998',
        'توییتر': '#1DA1F2'
      };

      const defaultColors = [
        '#FF6384', '#36A2EB', '#FFCE56', '#4BC0C0', '#9966FF', '#FF9F40'
      ];

      const backgroundColors = (data.labels || []).map((label, i) => {
        return labelColorMap[label] || defaultColors[i % defaultColors.length];
      });

      const borderColors = backgroundColors.map(c => shadeColor(c, -20));

      window._myChart = new Chart(ctx, {
        type: 'doughnut',
        data: {
          labels: data.labels || [],
          datasets: [{
            label: 'تعداد استفاده از پیامرسان ها',
            data: data.values || [],
            backgroundColor: backgroundColors,
            borderColor: borderColors,
            borderWidth: 2,
            hoverOffset: 30,
          }]
        },
        options: {
          responsive: true,
          maintainAspectRatio: false,
          cutout: '70%',
          animation: {
            animateRotate: true,
            animateScale: true
          },
          plugins: {
            title: {
              display: true,
              text: 'تعداد استفاده از پیامرسان‌ها',
              font: {
                size: 18,
                family: "'Vazirmatn', sans-serif",
                weight: 'bold'
              },
              color: '#333',
              padding: {
                top: 10,
                bottom: 20
              },
              align: 'center'
            },
            legend: {
              position: 'bottom',
              labels: {
                font: {
                  size: 14,
                  family: "'Vazirmatn', sans-serif"
                },
                color: '#444',
                padding: 20,
                usePointStyle: true,
                pointStyle: 'circle',

              }
            },
            centerText: {
              display: true,
            },
            tooltip: {
              enabled: true,
              backgroundColor: 'rgba(0,0,0,0.7)',
              titleFont: {
                family: "'Vazirmatn', sans-serif",
                size: 16,
                weight: 'bold'
              },
              bodyFont: {
                family: "'Vazirmatn', sans-serif",
                size: 14
              },
              padding: 10,
              cornerRadius: 8,
              displayColors: true,
              callbacks: {
                label: context => {
                  const label = context.label || '';
                  const value = context.parsed || 0;
                  return `${label}: ${value.toLocaleString('fa-IR')}`;
                }
              }
            }
          }
        }
      });
    });
}

// تابع برای تیره‌تر کردن رنگ (شیدینگ)
function shadeColor(color, percent) {
  let f = parseInt(color.slice(1),16),t=percent<0?0:255,p=percent<0?percent*-1:percent;
  let R = f>>16,G = f>>8&0x00FF,B = f&0x0000FF;
  return "#" + (0x1000000 + (Math.round((t - R)*p/100)+R)*0x10000
    + (Math.round((t - G)*p/100)+G)*0x100
    + (Math.round((t - B)*p/100)+B)).toString(16).slice(1);
}



