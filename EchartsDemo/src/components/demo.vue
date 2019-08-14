<template>
  <div>
    <div id="myChart" :style="{width: '1000px', height: '400px'}"></div>
  </div>
</template>
<script>
  // 引入基本模板
  let echarts = require('echarts/lib/echarts');
  // 引入柱状图组件
  require('echarts/lib/chart/bar');
  require('echarts/lib/chart/line');
  // 引入提示框和title组件
  require('echarts/lib/component/tooltip');
  require('echarts/lib/component/title');
  export default {
    name: "DataCount",
    data: () => ({}),
    mounted() {
      this.charts();
    },
    methods: {
      charts() {
        let myChart = this.$echarts.init(document.getElementById('myChart'));
        // 绘制图表
        this.$axios.get("/api/select").then(response => {
          let res = response.data;
          let data = res.list;
          let dateData = [];
          let seriesData = [];
          let obj = {};
          let outObj = {};
          for (let i = 0; i < data.length; i++) {
            obj = data[i].date;
            outObj = data[i].num;
            dateData.push(obj);
            seriesData.push(outObj);
          }
          myChart.setOption({
            title: {
              text: '温度变化',
              subtext: ''
            },
            tooltip: {
              trigger: 'axis'
            },
            legend: {
              data: ['温度']
            },
            toolbox: {
              show: true,
              feature: {
                magicType: {
                  type: ['line', 'bar']
                }, //折线图和柱状图转换
              }
            },
            xAxis: {
              type: 'category',
              boundaryGap: false,
              data: dateData
            },
            yAxis: {},
            series: [{
              name: '温度',
              type: 'line',
              data: seriesData
            }],
          });
        });
      },
    },
  }
</script>
