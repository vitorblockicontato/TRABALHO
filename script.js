let cookies = 0;
let cookiesPorClique = 1;

let custoUpgrade = 10;
let custoAuto = 50;

let autoClickers = 0;

const cookiesTexto = document.getElementById("cookies");
const porCliqueTexto = document.getElementById("porClique");
const custoUpgradeTexto = document.getElementById("custoUpgrade");
const custoAutoTexto = document.getElementById("custoAuto");
const cookieBotao = document.getElementById("cookie");

cookieBotao.addEventListener("click", () => {
  cookies += cookiesPorClique;
  atualizarTela();
});

function comprarUpgrade() {
  if (cookies >= custoUpgrade) {
    cookies -= custoUpgrade;
    cookiesPorClique++;
    custoUpgrade = Math.floor(custoUpgrade * 1.8);
    atualizarTela();
  } else {
    alert("Cookies insuficientes!");
  }
}

function comprarAutoClicker() {
  if (cookies >= custoAuto) {
    cookies -= custoAuto;
    autoClickers++;
    custoAuto = Math.floor(custoAuto * 2);
    atualizarTela();
  } else {
    alert("Cookies insuficientes!");
  }
}

setInterval(() => {
  cookies += autoClickers;
  atualizarTela();
}, 1000);

function atualizarTela() {
  cookiesTexto.textContent = cookies;
  porCliqueTexto.textContent = cookiesPorClique;
  custoUpgradeTexto.textContent = custoUpgrade;
  custoAutoTexto.textContent = custoAuto;
}