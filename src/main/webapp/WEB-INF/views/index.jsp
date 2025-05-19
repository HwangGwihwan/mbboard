<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>접속자 통계</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>
  body {
    font-family: 'Segoe UI', sans-serif;
    background-color: #f8f9fa;
    margin: 0;
    padding: 20px;
  }

  a {
    float: right;
    margin-bottom: 20px;
    text-decoration: none;
    color: #007bff;
    font-weight: bold;
  }

  h2 {
    text-align: center;
    color: #333;
    margin-bottom: 30px;
  }

  .chart-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 20px;
  }

  .chart-box {
    background-color: #fff;
    border: 1px solid #dee2e6;
    box-shadow: 0 2px 6px rgba(0, 0, 0, 0.08);
    border-radius: 8px;
    padding: 15px;
    text-align: center;
    width: 300px;
  }

  .chart-box h3 {
    margin-top: 0;
    color: #444;
    font-size: 1.1em;
    margin-bottom: 10px;
  }

  .number-display {
    font-size: 3em;
    font-weight: bold;
    color: #9b59b6;
    margin-top: 20px;
  }

  canvas {
    max-width: 100%;
    max-height: 150px;
  }
</style>
</head>
<body>

  <a href="/login">로그인</a>
  <h2>접속자 통계</h2>

  <div class="chart-container">
    <!-- 전체 접속자 -->
    <div class="chart-box">
      <h3>전체</h3>
      <canvas id="chartAll"></canvas>
    </div>

    <!-- 오늘 접속자 -->
    <div class="chart-box">
      <h3>오늘</h3>
      <canvas id="chartToday"></canvas>
    </div>

    <!-- 현재 접속자 (차트 대신 숫자만 표시) -->
    <div class="chart-box">
      <h3>현재 접속자</h3>
      <div class="number-display">${currentConnectCount}</div>
    </div>
  </div>

<script>
  // 전체 통계
  const dataAll = {
    labels: ['ANONYMOUS', 'MEMBER', 'ADMIN'],
    datasets: [{
      label: '전체 접속자 수',
      data: [${connectCountMapAll.ANONYMOUS}, ${connectCountMapAll.MEMBER}, ${connectCountMapAll.ADMIN}],
      backgroundColor: ['#f39c12', '#2980b9', '#27ae60']
    }]
  };
  new Chart(document.getElementById('chartAll'), {
    type: 'bar',
    data: dataAll,
    options: {
      scales: {
        y: { beginAtZero: true }
      },
      plugins: {
        legend: { display: false }
      }
    }
  });

  // 오늘 통계
  const dataToday = {
    labels: ['ANONYMOUS', 'MEMBER', 'ADMIN'],
    datasets: [{
      label: '오늘 접속자 수',
      data: [${connectCountMapToday.ANONYMOUS}, ${connectCountMapToday.MEMBER}, ${connectCountMapToday.ADMIN}],
      backgroundColor: ['#e67e22', '#3498db', '#2ecc71']
    }]
  };
  new Chart(document.getElementById('chartToday'), {
    type: 'bar',
    data: dataToday,
    options: {
      scales: {
        y: { beginAtZero: true }
      },
      plugins: {
        legend: { display: false }
      }
    }
  });
</script>

</body>
</html>
