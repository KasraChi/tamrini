fetch('/api/registeringStatus')
  .then(res => res.json()
    .then(data => {
      const canvas = document.getElementById('myChart');
      if (!canvas) {
        console.error('Canvas not found');
        return;
      }
      const ctx = canvas.getContext('2d');
      if (!ctx) {
        console.error('2d ctx not found');
        return;
      }

      // اگر قبلاً یک چارت ساخته شده، آن را پاک کن (در حالت reload)
      if (window._myChart) {
        window._myChart.destroy();
        window._myChart = null;
      }

      const gradientColors = [
        'rgba(255, 99, 132, 0.7)',
        'rgba(54, 162, 235, 0.7)',
        'rgba(255, 206, 86, 0.7)',
        'rgba(75, 192, 192, 0.7)',
        'rgba(153, 102, 255, 0.7)'
      ];

      const borderColors = [
        'rgba(255, 99, 132, 1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)'
      ];

      window._myChart = new Chart(ctx, {
        type: 'bar',
        data: {
          labels: data.labels || [],
          datasets: [{
            label: 'وضعیت ثبت نام',
            data: data.values || [],
            backgroundColor: gradientColors,
            borderColor: borderColors,
            borderWidth: 2,
            borderRadius: 8, // گوشه‌های گرد
            barThickness: 40  // ضخامت بارها
          }]
        },
        options: {
          plugins: {
            legend: {
              display: false
            },
            title: {
              display: true,
              text: 'وضعیت ثبت نام',
              font: {
                family: 'Vazir, Tahoma, sans-serif',
                size: 16,
                weight: 'bold'
              },
              padding: {
                top: 10,
                bottom: 20
              }
            },
            tooltip: {
              enabled: true,
              backgroundColor: 'rgba(0,0,0,0.8)',
              titleFont: { family: 'Vazir', weight: 'bold' },
              bodyFont: { family: 'Vazir' },
              padding: 10
            },
            datalabels: {
              display: true,
              color: '#444',
              anchor: 'end',
              align: 'top',
              font: { family: 'Vazir', size: 12, weight: 'bold' }
            }
          },
          scales: {
            y: {
              ticks: {
                precision: 0,
                font: {
                  family: 'Vazir',
                  size: 12
                }
              },
              grid: {
                color: 'rgba(0,0,0,0.05)',
                borderDash: [3, 3]
              }
            },
            x: {
              ticks: {
                font: {
                  family: 'Vazir',
                  size: 12
                }
              },
              grid: {
                display: false
              }
            }
          }
        }
        // plugins: [ChartDataLabels] // اگه میخوای اعداد بالای بارها نمایش داده بشه
      });}))






//   window._myChart = new Chart(ctx, {
    //     type: 'bar',
    //     data: {
    //       labels: data.labels || [],
    //       datasets: [{
    //         label: 'وضعیت ثبت نام',
    //         data: data.values || [],
    //         backgroundColor: [
    //           'rgba(255,99,132,0.2)', 'rgba(98,213,68,0.2)', 'rgba(255,206,86,0.2)', 'rgba(83,192,75,0.2)', 'rgba(80,162,235,0.2)'],
    //         borderColor: [
    //           'rgb(151,40,40)', 'rgb(200,12,35)', 'rgba(255,206,86,1)', 'rgba(75,192,192,1)'
    //         ],
    //         borderWidth: 1
    //       }]
    //     },
    //     options: {
    //       plugins: {
    //         legend: {
    //           display: false  // مستطیل رنگی کنار عنوان حذف می‌شود
    //         },
    //         title: {
    //           display: true, // عنوان بالا نمایش داده می‌شود
    //           text: 'وضعیت ثبت نام',
    //           font: {
    //             // family: 'Tahoma',
    //             // weight: 'bold',
    //             // style: 'italic',
    //             size: 12
    //           },
    //           padding: {
    //             top: 10,
    //             bottom: 30
    //           }
    //         }
    //       },
    //       scales: {
    //         y: {
    //           ticks: {
    //             precision: 0
    //           }
    //         }
    //       }
    //     }
    //   });
    // }));
